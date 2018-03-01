package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Enbi implements Executable {
    // ENBI
    // INTE = 1
    

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
       regs[INTE] = regs[ONE];
    }
}
