
package instructions;

import h32.Executable;
import static h32.RegisterManipulator.PC;

/**
 *
 * @author pcctoo
 */
public class Dect implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar,boolean trace) {
           regs[CT] = regs[CT] - regs[ONE];
                if (regs[CT] == 0) {
                    regs[PC] = regs[PC] + 1;
    }

             
    }
}
