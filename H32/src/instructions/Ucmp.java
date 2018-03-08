
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Ucmp implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
         // UCMP X
         long ac = (long) regs[AC];
         long meml = (long) mem[mar];
         regs[AC] = (int)(ac-meml);
                 
    }
    
}
