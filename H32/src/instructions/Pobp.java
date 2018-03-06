
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua "the person-like" Neilson
 */
public class Pobp implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // POBP: pop BP
        // REG[BP] = MEM[REG[SP]++]
        regs[BP] = mem[regs[BP]++];
    }
    
}
