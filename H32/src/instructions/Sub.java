
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Sub implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
       // SUB X
                // AC = AC - MEM[X]
                int old = regs[AC];
                regs[AC] = regs[AC] - mem[mar];
    }
    
}
