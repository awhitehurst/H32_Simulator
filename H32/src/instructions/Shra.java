
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Shra implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                // SHRA X
                // AC = AC >> X (inject sign)
                int mask = 0;
                if (regs[AC] < 0) {
                    mask = 0x80000000;
                }
                for (int i = 0; i < (mar & 0x1F); ++i) {
                    regs[AC] = (regs[AC] >> 1) | mask;
                }
    }
    
}
