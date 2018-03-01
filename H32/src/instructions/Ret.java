
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Ret implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                // RET
                // PC = MEM[SP++]
                regs[PC] = mem[regs[SP]++];
    }
    
}
