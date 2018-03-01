package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Flip implements Executable {
    // FLIP
           

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
             regs[AC] = ~regs[AC];
    }
}
