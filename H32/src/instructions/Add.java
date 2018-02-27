package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Add implements Executable {
    
    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        //AC = AC + mem{X}; CY = CARRY
        // case 0x02:
        long result = (long) regs[AC] + (long) mem[mar];
        regs[AC] = (int) result;
        if (result > 0xFFFFFFFFL) {
            regs[CY] = 1;
        } else {
            regs[CY] = 0;
        }
    }

}
