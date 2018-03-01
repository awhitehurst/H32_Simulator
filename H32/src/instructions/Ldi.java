
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Ldi implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // LDI
        // AC = MEM[AC]
        regs[AC] = mem[regs[AC] & 0xFFFFFF];
    }
}
