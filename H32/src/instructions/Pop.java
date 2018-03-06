
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian "the man, the myth, the legend" Sanchez
 */
public class Pop implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                // POP
                // AC = MEM[SP++]
                regs[AC] = mem[regs[SP]++];
    }
    
}