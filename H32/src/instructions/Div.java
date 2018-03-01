
package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Div implements Executable{             

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
           regs[AC] = regs[AC] / mem[mar];
    }

                
}
