package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Esba implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        //ESBA
        // mem[--SP]=BP;BP=SP
        mem[--regs[SP]] = regs[BP];
        regs[BP] = regs[SP];
    }

}
