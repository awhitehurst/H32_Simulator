package instructions;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Addy implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // ADDY X
        // AC = AC + MEM[X] + CY;CY = carry
        long result = (long) regs[AC] + (long) mem[mar] + (long) regs[CY];
        regs[AC] = (int) result;
        if (result > 0xFFFFFFFF) {
            regs[CY] = 1;
        } else {
            regs[CY] = 0;
        }
    }
}
