
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Swap implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
       // SWAP
                // TMP=AC;AC=SP;SP=TMP
                regs[TMP] = regs[AC];
                regs[AC] = regs[SP];
                regs[SP] = regs[TMP];
    }
    
}
