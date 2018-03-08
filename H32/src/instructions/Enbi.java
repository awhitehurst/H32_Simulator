package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Enbi implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // ENBI
        // INTE = 1
        regs[INTE] = regs[ONE];
    }
}
