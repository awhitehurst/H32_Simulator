package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Bcpy implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // BCPY X
        // temp = mar;while(ct--){mem[ac++] = mem[temp++]
        while(regs[CT]>0){
            mem[regs[AC]++] = mem[mar++];
            regs[CT]--;
        }
    }
}
