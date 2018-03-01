
package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Jn implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        if (regs[AC] < 0) {
                    regs[PC] = mar;
                }
    }
    
}
