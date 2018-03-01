package instructions;

import h32.Executable;


/**
 *
 * @author Alex
 */
public class Disi implements Executable{
    // DISI
    // INTE = 0
    

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        regs[INTE] = regs[ZERO];
    }
                
}
