package instructions;

import h32.Executable;


/**
 *
 * @author Joshua Neilson
 */
public class Sti implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
       mem[regs[AC] & 0xFFFFFF] = mem[regs[SP]++];
    }
    
}
