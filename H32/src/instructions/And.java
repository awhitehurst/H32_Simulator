package instructions;

import h32.Executable;
import h32.H32;

/**
 *
 * @author pcctoo
 */
public class And implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // AND X
        // REG[AC] = REG[AC] & MEM[MAR];
        regs[AC] = regs[AC] & mem[mar];

    }

}
