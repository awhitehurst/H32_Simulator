
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua "i am out of nicknames" Neilson
 */
public class Reba implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // REBA
                // SP = BP;BP=MEM[SP++]
                regs[SP] = regs[BP];
                regs[BP] = mem[regs[SP]++];
    }
    
}
