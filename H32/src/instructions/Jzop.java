
package instructions;

import h32.Executable;


/**
 *
 * @author the one and only, hannah smith
 */
public class Jzop implements Executable{
     // JZOP X
                // if(AC>=0) PC = X;
               

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
      if (regs[AC] >= 0) {
                    regs[PC] = mar;}
    }
}
