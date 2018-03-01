
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Uout implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // UOUT
                // console << (unsigned) AC
                System.out.printf("%d", regs[AC] & 0xFFFFFFFF);
    }
    
}
