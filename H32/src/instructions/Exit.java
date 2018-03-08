package instructions;

import h32.Executable;


/**
 *
 * @author Alex
 */
public class Exit implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar,boolean trace) {
        // EXIT X
        // return to the operating system
        regs[AC] = mar;
        // need to execute a system call at this point
    }
    
}
