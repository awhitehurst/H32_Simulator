package h32;

import instructions.Exit;
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
public class H32 implements RegisterManipulator {

    private int[] REG;
    private int[] MEM;
    private int MAR;
    private int TMR;
    private boolean trace;
    private Scanner console;
    private int[] REC;
    private Executable[] inst = {
        new Ld(),new St(),new Add(),new Sub(), new Ldr(),new Str(),new Addr(),new Subr(), new Ldc(), new Ja(),new Jzop(), new Jn(), new Jz(), new Jnz(),new Call(),new Ret(), 
        new Ldi(), new Sti(), new Push(),new Pop(), new Aloc(), new Dloc(),new Swap(),new Addc(), new Subc(),new Esba(),new Reba(),new Cora(), new Scmp(), new Ucmp(), new Shll(), new Shrl(), 
        new Shra(),new Muls(),new Mult(),new Div(),  new Rem(),new Addy(), new Or(),new Xor(),  new And(), new Flip(), new Cali(), new Sect(), new Dect(), new Sodd(), new Bpbp(), new Pobp(), 
        new Pbp(),new Bcpy(),new Sysc(), new Exit(), new Ittb(), new Iitb(),new Enbi(), new Disi(), null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, new Uout(), new Sin(), new Sout(), new Hin(), new Hout(), new Ain(), new Aout(), new Din(), new Dout(), null, null};

    public H32() {
        console = new Scanner(System.in);
        REG = new int[32];
        MEM = new int[0x1000000];
        REG[ZERO] = 0;
        REG[ONE] = 1;
        REG[XM] = 0xFFFFFF;
        REG[YM] = 0xFFFF;
        REG[ZM] = 0XFF;
        REG[SP] = 0x100000;
    }
    
    public int [] getRegs(){
        return REG;
    }
    
    public int[] getMem(){
        return MEM;
    }

    public void init() {
        // this isn't right if we have multiple process
        REG[SP] = 0x1000;
    }

    public void step() {
        REC = Arrays.copyOf(REG, 32);
        REG[IR] = MEM[REG[PC]];
        REG[PC]++;
        //decode
        int opcode = REG[IR] >>> 24;
        MAR = REG[IR] & REG[XM];
        // execute instruction
        if (trace) {
            System.out.printf("MEM[%08X]=%08X (%4s %06X): ", REC[PC], MEM[REC[PC]], nmemonics[opcode], MAR);
        }
        int old = 0;
        inst[opcode].execute(REG, MEM, MAR, trace);
        traceChangedRegs();
    }

    public void load(String[] args) {
        String filename;
        if (args.length == 0) {
            System.out.println("Enter filename: ");
            Scanner input = new Scanner(System.in);
            filename = input.nextLine();
        } else {
            //  need to load multiple files
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
                if (header && i == (int) 'T') {
                    header = false;
                } else if(header && (i&0x73000000)==0x73000000) {
                    REG[PC] = i&0x00FFFFFF;
                }else if (!header) {
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
                    while (REG[IR] != 0x33000000) {
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

    private static final String[] regNames = {
        "ZERO", "ONE", "XM", "YM", "ZM", "MDR", "PC", "SP", "AC", "IR", "CT", "CY", "BP", "MB", "DC", "0F",
        "MODE", "TTB", "ITB", "INTE", "INTX", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F",};

    private static final String[] nmemonics = {
        "LD", "ST", "ADD", "SUB", "LDR", "STR", "ADDR", "SUBR", "LDC", "JA", "JZOP", "JN", "JZ", "JNZ", "CALL", "RET",
        "LDI", "STI", "PUSH", "POP", "ALOC", "DLOC", "SWAP", "ADDC", "SUBC", "ESBA", "REBA", "CORA", "SCMP", "UCMP", "SHLL", "SHRL",
        "SHRA", "MUL", "MULT", "DIV", "REM", "ADDY", "OR", "XOR", "AND", "FLIP", "CALI", "SECT", "DECT", "SODD", "BPBP", "POBP",
        "PBP", "BCPY", "SYSC", "EXIT", "ITTB", "IITB", "ENBI", "DISI", "", "", "", "", "", "", "", "",
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