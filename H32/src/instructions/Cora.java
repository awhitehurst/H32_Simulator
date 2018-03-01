package instructions;

import h32.Executable;




/**
 *
 * @author Alex
 */public class Cora implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
         regs[AC] = regs[AC] + regs[BP];
         
    }
                
}
