package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Sout implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
         // SOUT
                // console << MEM[AC]
                int addr = regs[AC];
                while (mem[addr] != 0) {
                    System.out.printf("%c", (char) mem[addr++]);
                }
    }
    
}
