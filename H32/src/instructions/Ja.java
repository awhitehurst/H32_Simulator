
package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Ja implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
         regs[PC] = mar;
    }
    
}
