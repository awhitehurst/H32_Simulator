
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Shll implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                // SHLL X
                // AC = AC << X (inject 0's)
                regs[AC] = regs[AC] << mar;
    }
    
}
