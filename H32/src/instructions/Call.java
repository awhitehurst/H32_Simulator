
package instructions;

import h32.Executable;


/**
 *
 * @author pcctoo
 */
public class Call implements Executable{
     // CALL X
                // MEM[--SP] = PC; PC = X;
        

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                mem[--regs[SP]] = regs[PC];
                regs[PC] = mar;
    }
               
}
