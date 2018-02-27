package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Muls implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // MULS X
        // AC = AC * MEM[X]
        // REG[AC] = REG[AC] * MEM[MAR];        int OFFSET = 0;
        regs[AC] = regs[AC] * mem[mar];
    }

}
