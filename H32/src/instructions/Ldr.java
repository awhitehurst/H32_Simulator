
package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Ldr implements Executable {
    // LDR S
    // AC = MEM[BP+S]

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {

        int OFFSET = 0;
        if ((mar & 0x800000) == 0x800000) {
            OFFSET = ((~mar & 0xFFFFFF) + 1) * -1;
        } else {
            OFFSET = mar;
        }
        regs[AC] = mem[regs[BP] + OFFSET];
    }

}
