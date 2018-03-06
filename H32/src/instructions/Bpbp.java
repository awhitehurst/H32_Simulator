package instructions;

import h32.Executable;
/**
 *
 * @author Alex
 */
public class Bpbp implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // BPBP
        // REG[BP] = MEM[REG[BP]]
        regs[BP] = mem[regs[BP]];
    }
    
}
