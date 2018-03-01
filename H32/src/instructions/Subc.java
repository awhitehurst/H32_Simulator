
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Subc implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // SUBC X
        // AC = AC - X
        regs[AC] -= mar;
    }

}
