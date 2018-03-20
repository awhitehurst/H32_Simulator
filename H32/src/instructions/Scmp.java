
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Scmp implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // SCPM
        // TMP = MEM[SP++]
        throw new java.lang.UnsupportedOperationException();
    }
    
}
