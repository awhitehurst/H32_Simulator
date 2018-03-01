
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Shrl implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                // SHRL X
                // AC = AC >> X (inject 0's)
                regs[AC] = regs[AC] >> (mar & 0x1F);
    }
    
}
