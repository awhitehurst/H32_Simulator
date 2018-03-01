package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Addc implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // ADDC X
        // AC = AC + X
        regs[AC] += mar;
    }
}
