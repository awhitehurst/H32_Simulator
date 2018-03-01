
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Rem implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                // REM X
                // AC = AC % MEM[X]
                regs[AC] = regs[AC] % mem[mar];
    }
    
}
