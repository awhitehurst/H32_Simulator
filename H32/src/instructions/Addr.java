package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Addr implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // ADDR S
        // AC = AC + MEM[BP + S]; CY = CARRY
        int OFFSET = 0;
        if ((mar & 0x800000) == 0x800000) {
            OFFSET = ((~mar & 0xFFFFFF) + 1) * -1;
        } else {
            OFFSET = mar;
        }
        long result = (long) regs[AC] + (long) mem[regs[BP] + OFFSET];
        regs[AC] = (int) result;
        if (result > 0xFFFFFFFF) {
            regs[CY] = 1;
        } else {
            regs[CY] = 0;
        }
    }

}
