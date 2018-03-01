
package instructions;

import h32.Executable;



/**
 *
 * @author Alex
 */
public class Dout implements Executable {
    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
            System.out.printf("%d", regs[AC]); 
    }
}
