package instructions;

import h32.Executable;


/**
 *
 * @author pcctoo
 */
public class Aloc implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // ALOC X
        // SP = SP - X
        regs[SP] = regs[SP] - mar;
    }

}
