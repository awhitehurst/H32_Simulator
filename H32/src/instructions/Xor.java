
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Xor implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // XOR X
                // AC = AC ? MEM[X]
                regs[AC] = ~(regs[AC] & mem[mar]) & ~(~regs[AC] & ~mem[mar]);
    }
    
}
