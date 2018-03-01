
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua "fluffyface" Neilson
 */
public class Mult implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // MULT X
        // AC = AC * MEM[X]
        regs[AC] = regs[AC] * mem[mar];
    }
    
}
