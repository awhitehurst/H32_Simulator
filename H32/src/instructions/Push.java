
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Push implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        mem[--regs[SP]] = regs[AC];
    }
    
}
