
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Sect implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // SECT X
        // CT = MEM[X];
        regs[CT] = mem[mar];
    }
    
}
