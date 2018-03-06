package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Hout implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // HOUT
        // console << (HEX) AC
        System.out.printf("%h", regs[AC]);
    }

}
