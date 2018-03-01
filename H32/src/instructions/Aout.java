package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Aout implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // AOUT
        // console << (char) AC
        System.out.printf("%c", regs[AC]);
    }

}
