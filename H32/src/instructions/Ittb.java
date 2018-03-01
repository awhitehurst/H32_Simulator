
package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Ittb implements Executable{
        // ITTB X
                // TTB = X
       

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
           regs[TTB] = mar;
    }
       
}
