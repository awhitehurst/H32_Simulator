
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Pbp implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // PBP: push BP
        // MEM[--REG[SP]] = REG[BP]
        mem[--regs[SP]] = regs[BP];
    }
    
}
