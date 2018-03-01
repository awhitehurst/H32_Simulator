
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Sodd implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // SODD
                // if((AC % 2) == 1) PC = PC + 1;
                if ((regs[AC] % 2) == 1) {
                    regs[PC] = regs[PC] + 1;
                }
    }
    
}
