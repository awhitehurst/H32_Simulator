package instructions;

import h32.Executable;
import h32.H32;

/**
 *
 * @author pcctoo
 */
public class Dloc implements Executable{
    // DLOC X
                // SP = SP + X
             

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
          regs[SP] = regs[SP] + mar;
    }
        
}
