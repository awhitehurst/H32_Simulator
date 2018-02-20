package h32;

import instructions.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alan.whitehurst
 */
public class H32 {

    private int[] REG;
    private int[] MEM;
    private int MAR;
    private int TMR;
    private boolean trace;
    private Scanner console;
    private int[] REC;
    private Executable[] inst = {new Ld(),null,null,null,new Ldr(),};

    public H32() {
        console = new Scanner(System.in);
        REG = new int[32];
        MEM = new int[0x1000000];
        REG[ZERO] = 0;
        REG[ONE] = 1;
        REG[XM] = 0xFFFFFF;
        REG[YM] = 0xFFFF;
        REG[ZM] = 0XFF;
    }

    public void init() {
        REG[SP] = 0x100000;
    }

    public void step() {
        REC = Arrays.copyOf(REG, 32);
        REG[IR] = MEM[REG[PC]];
        REG[PC]++;
        //decode
        int opcode = REG[IR] >>> 24;
        MAR = REG[IR] & REG[XM];
//        int OFFSET = 0;
//        if ((MAR & 0x800000) == 0x800000) {
//            OFFSET = ((~MAR & 0xFFFFFF) + 1) * -1;
//        } else {
//            OFFSET = MAR;
//        }
        // execute instruction
        if (trace) {
            System.out.printf("MEM[%08X]=%08X (%4s %06X): ", REC[PC], MEM[REC[PC]], nmemonics[opcode], MAR);
        }
        int old = 0;
        inst[opcode].execute(REG, MEM, MAR);
        // everything from here to the end of this method gets removed
        switch (opcode) {
            case 0x00:
                // LD X
                // AC = MEM[x]
                //REG[AC] = MEM[MAR];
                //break;
                new Ld().execute(REG, MEM, MAR); 
                break;
            case 0x01:
                // ST X
                // MEM[x] = AC
                old = MEM[MAR];
                MEM[MAR] = REG[AC];
                if (trace) {
                    System.out.printf("  MEM[%08X]=%08X/%08X; ", MAR, old, MEM[MAR]);
                }
                break;
            case 0x02:
                // ADD X
                // AC = AC + MEM{X}; CY = CARRY
                old = REG[AC];
                long result = (long) REG[AC] + (long) MEM[MAR];
                REG[AC] = (int) result;
                if (result > 0xFFFFFFFFL) {
                    REG[CY] = 1;
                } else {
                    REG[CY] = 0;
                }
                break;
            case 0x03:
                // SUB X
                // AC = AC - MEM[X]
                old = REG[AC];
                REG[AC] = REG[AC] - MEM[MAR];
                break;
            case 0x04:
                // LDR S
                // AC = MEM[BP+S]
                new Ldr().execute(REG, MEM, MAR); 
                break;
            case 0x05:
                // STR S
                // AC = MEM[BP+S]
                old = MEM[REG[BP] + OFFSET];
                MEM[REG[BP] + OFFSET] = REG[AC];
                if (trace) {
                    System.out.printf("MEM[%08X]=%08X/%08X; ", MAR, old, MEM[MAR]);
                }
                break;
            case 0x06:
                // ADDR S
                // AC = AC + MEM[BP + S]; CY = CARRY
                result = (long) REG[AC] + (long) MEM[REG[BP] + OFFSET];
                REG[AC] = (int) result;
                if (result > 0xFFFFFFFF) {
                    REG[CY] = 1;
                } else {
                    REG[CY] = 0;
                }
                break;
            case 0x07:
                // SUBR S
                // AC = AC - MEM[BP + S]
                REG[AC] -= MEM[REG[BP] + OFFSET];
                break;
            case 0x08:
                // LDC X
                // AC = X
                old = REG[AC];
                REG[AC] = MAR;
                break;
            case 0x09:
                // JA X
                // PC = X
                REG[PC] = MAR;
                break;
            case 0x0A:
                // JZOP X
                // if(AC>=0) PC = X;
                if (REG[AC] >= 0) {
                    REG[PC] = MAR;
                }
                break;
            case 0x0B:
                // JN X
                // if(AC<0) PC = X;
                if (REG[AC] < 0) {
                    REG[PC] = MAR;
                }
                break;
            case 0x0C:
                // JZ X
                // if(AC==0) PC = X;
                if (REG[AC] == 0) {
                    REG[PC] = MAR;
                }
                break;
            case 0x0D:
                // JNZ X
                // if(AC!=0) PC = X
                if (REG[AC] != 0) {
                    REG[PC] = MAR;
                }
                break;
            case 0x0E:
                // CALL X
                // MEM[--SP] = PC; PC = X;
                MEM[--REG[SP]] = REG[PC];
                REG[PC] = MAR;
                break;
            case 0x0F:
                // RET
                // PC = MEM[SP++]
                REG[PC] = MEM[REG[SP]++];
                break;
            case 0x10:
                // LDI
                // AC = MEM[AC]
                REG[AC] = MEM[REG[AC] & 0xFFFFFF];
                break;
            case 0x11:
                // STI
                MEM[REG[AC] & 0xFFFFFF] = MEM[REG[SP]++];
                break;
            case 0x12:
                // PUSH
                MEM[--REG[SP]] = REG[AC];
                break;
            case 0x13:
                // POP
                // AC = MEM[SP++]
                REG[AC] = MEM[REG[SP]++];
                break;
            case 0x14:
                // ALOC X
                // SP = SP - X
                REG[SP] = REG[SP] - MAR;
                break;
            case 0x15:
                // DLOC X
                // SP = SP + X
                REG[SP] = REG[SP] + MAR;
                break;
            case 0x16:
                // SWAP
                // TMP=AC;AC=SP;SP=TMP
                REG[TMP] = REG[AC];
                REG[AC] = REG[SP];
                REG[SP] = REG[TMP];
                break;
            case 0x17:
                // ADDC X
                // AC = AC + X
                REG[AC] += MAR;
                break;
            case 0x18:
                // SUBC X
                // AC = AC - X
                REG[AC] -= MAR;
                break;
            case 0x19:
                // ESBA
                // MEM[--SP]=BP;BP=SP
                MEM[--REG[SP]] = REG[BP];
                REG[BP] = REG[SP];
                break;
            case 0x1A:
                // REBA
                // SP = BP;BP=MEM[SP++]
                REG[SP] = REG[BP];
                REG[BP] = MEM[REG[SP]++];
                break;
            case 0x1B:
                // CORA
                // AC = AC + BP
                REG[AC] = REG[AC] + REG[BP];
                break;
            case 0x1C:
                // SCPM
                // TMP = MEM[SP++]
                throw new java.lang.UnsupportedOperationException();
            //break;
            case 0x1D:
                // UCMP
                throw new java.lang.UnsupportedOperationException();
            case 0x1E:
                // SHLL X
                // AC = AC << X (inject 0's)
                REG[AC] = REG[AC] << MAR;
                break;
            case 0x1F:
                // SHRL X
                // AC = AC >> X (inject 0's)
                REG[AC] = REG[AC] >> (MAR & 0x1F);
                break;
            case 0x20:
                // SHRA X
                // AC = AC >> X (inject sign)
                int mask = 0;
                if (REG[AC] < 0) {
                    mask = 0x80000000;
                }
                for (int i = 0; i < (MAR & 0x1F); ++i) {
                    REG[AC] = (REG[AC] >> 1) | mask;
                }
                break;
            case 0x21:
                // MULS X
                // AC = AC * MEM[X]
                REG[AC] = REG[AC] * MEM[MAR];
                break;
            case 0x22:
                // MULT X
                // AC = AC * MEM[X]
                REG[AC] = REG[AC] * MEM[MAR];
                break;
            case 0x23:
                // DIV X
                // AC = AC / MEM[X]
                REG[AC] = REG[AC] / MEM[MAR];
                break;
            case 0x24:
                // REM X
                // AC = AC % MEM[X]
                REG[AC] = REG[AC] % MEM[MAR];
                break;
            case 0x25:
                // ADDY X
                // AC = AC + MEM[X] + CY;CY = carry
                result = (long) REG[AC] + (long) MEM[MAR] + (long) REG[CY];
                REG[AC] = (int) result;
                if (result > 0xFFFFFFFF) {
                    REG[CY] = 1;
                } else {
                    REG[CY] = 0;
                }
                break;
            case 0x26:
                // OR X
                // AC = AC | MEM[X]
                REG[AC] = ~(~REG[AC] & ~MEM[MAR]);
                break;
            case 0x27:
                // XOR X
                // AC = AC ? MEM[X]
                REG[AC] = ~(REG[AC] & MEM[MAR]) & ~(~REG[AC] & ~MEM[MAR]);
                break;
            case 0x28:
                // AND X
                REG[AC] = REG[AC] & MEM[MAR];
                break;
            case 0x29:
                // FLIP
                REG[AC] = ~REG[AC];
                break;
            case 0x2A:
                // CALI
                // MEM[SP--] = PC;PC = AC
                MEM[REG[SP]--] = REG[PC];
                REG[PC] = REG[AC];
                break;
            case 0x2B:
                // SECT X
                // CT = MEM[X];
                REG[CT] = MEM[MAR];
                break;
            case 0x2C:
                // DECT
                // CT = CT - 1;if(CT==0) PC=PC+1;
                REG[CT] = REG[CT] - REG[ONE];
                if (REG[CT] == 0) {
                    REG[PC] = REG[PC] + 1;
                }
                break;
            case 0x2D:
                // SODD
                // if((AC % 2) == 1) PC = PC + 1;
                if ((REG[AC] % 2) == 1) {
                    REG[PC] = REG[PC] + 1;
                }
                break;
            case 0x2E:
                // BPBP
                throw new UnsupportedOperationException();
            case 0x2F:
                // POBP
                throw new UnsupportedOperationException();
            case 0x30:
                // PBP
                throw new UnsupportedOperationException();
            case 0x31:
                // BCPY
                throw new UnsupportedOperationException();
            case 0x32:
                // SYSC X
                // MEM[SP--] = PC; PC = MEM[TTB + X]
                MEM[REG[SP]--] = REG[PC];
                REG[PC] = MEM[REG[TTB] + MAR];
                break;
            case 0x33:
                // EXIT
                throw new UnsupportedOperationException();
            case 0x34:
                // ITTB X
                // TTB = X
                REG[TTB] = MAR;
                break;
            case 0x35:
                // IITB
                // ITB = X
                REG[ITB] = MAR;
                break;
            case 0x36:
                // ENBI
                // INTE = 1
                REG[INTE] = REG[ONE];
                break;
            case 0x37:
                // DISI
                // INTE = 0
                REG[INTE] = REG[ZERO];
                break;
            case 0xF5:
                // UOUT
                // console << (unsigned) AC
                System.out.printf("%d", REG[AC] & 0xFFFFFFFF);
                break;
            case 0xF6:
                // SIN
                // MEM[AC] << console
                String input = console.nextLine();
                for (int i = 0; i < input.length(); ++i) {
                    MEM[REG[AC] + i] = input.charAt(i);
                }
                MEM[REG[AC] + input.length()] = 0;
                break;
            case 0xF7:
                // SOUT
                // console << MEM[AC]
                int addr = REG[AC];
                while (MEM[addr] != 0) {
                    System.out.printf("%c", (char) MEM[addr++]);
                }
                break;
            case 0xF8:
                // HIN
                // AC << (Hex) console
                String hexInput = console.next("[0-9A-Fa-f]+").toUpperCase();
                int hexNumber = 0;
                for (int i = 0; i < hexInput.length(); ++i) {
                    if (Character.isDigit(hexInput.charAt(i))) {
                        hexNumber = hexNumber * 16 + (int) (hexInput.charAt(i) - '0');
                    } else {
                        hexNumber = hexNumber * 16 + (int) (hexInput.charAt(i) - 'A' + 10);
                    }
                    REG[AC] = hexNumber;
                }
                break;
            case 0xF9:
                // HOUT
                // console << (HEX) AC
                break;
            case 0xFA:
                // AIN
                // AC << (char) console
                break;
            case 0xFB:
                // AOUT
                // console << (char) AC
                System.out.printf("%c",REG[AC]);
                break;
            case 0xFC:
                // DIN
                // AC << (int) console
                REG[AC] = console.nextInt();
                break;
            case 0xFD:
                // DOUT
                // console << (int) AC
                System.out.printf("%d", REG[AC]);
                break;
            case 0xFF:
                // HALT
                break;
            default:
                throw new UnsupportedOperationException();
        }
        traceChangedRegs();
    }

    public void load(String[] args) {
        String filename;
        if (args.length == 0) {
            System.out.println("Enter filename: ");
            Scanner input = new Scanner(System.in);
            filename = input.nextLine();
        } else {
            filename = args[0];
        }
        File bootFile = new File(filename);
        if (!bootFile.exists() || !bootFile.canRead()) {
            System.out.println("File missing or corrupt.");
            System.exit(0);
        }
        try {
            DataInputStream data;
            data = new DataInputStream(new FileInputStream(bootFile));
            int memAddr = 0;
            boolean header = true;
            while (data.available() > 0) {
                int i = data.readInt();
                if (i == (int) 'T') {
                    header = false;
                } else if (!header) {
                    MEM[memAddr++] = i;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(H32.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(H32.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(String[] args) {
        load(args);
        init();
        while (true) {
            System.out.print("> ");
            String command = console.nextLine();
            String[] comArgs = command.split(" ");
            switch (comArgs[0]) {
                case "t":
                case "T":
                    trace = true;
                    int traceCount = 1;
                    if (comArgs.length > 1) {
                        traceCount = Integer.parseInt(comArgs[1]);
                    }
                    for (int step = 0; step < traceCount; ++step) {
                        if (isInterrupt()) {
                            handleInterrupt();
                        } else {
                            step();
                        }
                    }
                    trace = false;
                    break;
                case "d":
                case "D":
                    int startAddr = 0;
                    if (comArgs.length > 1) {
                        startAddr = Integer.parseInt(comArgs[1]);
                    }
                    int endAddr = 4096;
                    if (comArgs.length > 2) {
                        endAddr = Integer.parseInt(comArgs[2]);
                    }
                    for (int addr = startAddr; addr < endAddr; addr += 8) {
                        System.out.printf("%08X: ", addr);
                        for (int i = 0; i < 8; ++i) {
                            System.out.printf("%08X ", MEM[addr + i]);
                        }
                        System.out.println();
                    }
                    break;
                case "j":
                case "J":
                    if (comArgs.length > 1) {
                        startAddr = Integer.parseInt(comArgs[1]);
                        REG[PC] = startAddr;
                        System.out.printf("PC = %08X\n", REG[PC]);
                    }
                    break;
                case "r":
                case "R":
                    REG[PC] = 0x00000000;
                    REG[SP] = 0x100000;
                    while (REG[IR] != 0xFF000000) {
                        step();
                    }
                    break;
                case "q":
                case "Q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("???");
            }
        }
    }

    private void traceChangedRegs() {
        if (trace) {
            for (int i = 0; i < 32; ++i) {
                if (REC[i] != REG[i]) {
                    System.out.printf("%4s: %08X/%08X ", regNames[i], REC[i], REG[i]);
                }
            }
            System.out.println();
        }
    }

    private boolean isInterrupt() {
        return REG[INTE] == REG[1] && REG[INTX] != REG[ZERO];
    }

    private void handleInterrupt() {
        // save the PC-1 on the process stack
        MEM[REG[SP]--] = REG[PC] - 1;
        // switch to kernel mode
        REG[MODE] = REG[ZERO];
        // turn off interrupt processing
        REG[INTE] = REG[ZERO];
        // jump to the interrupt handler for interrupt INTX
        // note: interrupts are numbered from 1 to n,
        // interrupt handler must execute the equivallent
        // of a return for this process to continue
        REG[PC] = MEM[REG[ITB] + REG[INTX]];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new H32().run(args);
    }

    public static final byte ZERO = 0;
    public static final byte ONE = 1;
    public static final byte XM = 2;
    public static final byte YM = 3;
    public static final byte ZM = 4;
    public static final byte MDR = 5;
    public static final byte PC = 6;
    public static final byte SP = 7;
    public static final byte AC = 8;
    public static final byte IR = 9;
    public static final byte DC = 10;
    public static final byte CT = 11;
    public static final byte CY = 12;
    public static final byte BP = 13;
    public static final byte MB = 14;
    public static final byte F = 15;
    public static final byte MODE = 16;
    public static final byte TTB = 17;
    public static final byte ITB = 18;
    public static final byte INTE = 19;
    public static final byte INTX = 20;
    public static final byte R21 = 21;
    public static final byte R22 = 22;
    public static final byte R23 = 23;
    public static final byte R24 = 24;
    public static final byte R25 = 25;
    public static final byte R26 = 26;
    public static final byte R27 = 27;
    public static final byte R28 = 28;
    public static final byte R29 = 29;
    public static final byte R30 = 20;
    public static final byte TMP = 31;

    private static final String[] regNames = {
        "ZERO", "ONE", "XM", "YM", "ZM", "MDR", "PC", "SP", "AC", "IR", "DC", "CT", "CY", "BP", "MB", "0F",
        "MODE", "TTB", "ITB", "INTE", "INTX", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F",};

    private static final String[] nmemonics = {
        "LD", "ST", "ADD", "SUB", "LDR", "STR", "ADDR", "SUBR", "LDC", "JA", "JZOP", "JN", "JZ", "JNZ", "CALL", "RET",
        "LDI", "STI", "PUSH", "POP", "ALOC", "DLOC", "SWAP", "ADDC", "SUBC", "ESBA", "REBA", "CORA", "SCMP", "UCMP", "SHLL", "SHRL",
        "SHRA", "MUL", "MULT", "DIV", "REM", "ADDY", "OR", "XOR", "AND", "FLIP", "CALI", "SECT", "DECT", "SODD", "BPBP", "POBP",
        "PUBP", "BCPY", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "UOUT", "SIN", "SOUT", "HIN", "HOUT", "AIN", "AOUT", "DIN", "DOUT", "", "",};

}
