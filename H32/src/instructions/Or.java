
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Or implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        regs[AC] = ~(~regs[AC] & ~mem[mar]);
    }
    
}
