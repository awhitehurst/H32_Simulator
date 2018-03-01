
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Str implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // STR S
        // AC = MEM[BP+S]
        int OFFSET = 0;
        if ((mar & 0x800000) == 0x800000) {
            OFFSET = ((~mar & 0xFFFFFF) + 1) * -1;
        } else {
            OFFSET = mar;
        }
        int old = mem[regs[BP] + OFFSET];
        mem[regs[BP] + OFFSET] = regs[AC];
        if (trace) {
            System.out.printf("MEM[%08X]=%08X/%08X; ", mar, old, mem[mar]);
        }
    }

}
