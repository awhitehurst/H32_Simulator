package instructions;

import h32.Executable;


/**
 *
 * @author Joshua Neilson
 */
public class St implements Executable {

    private boolean trace;
    
    @Override
    public void execute(int[] regs, int[] mem, int mar) {
          // ST X
                // MEM[x] = AC
                long old = mem[mar];
                mem[mar] = regs[AC];
                if (trace) {
                    System.out.printf("  MEM[%08X]=%08X/%08X; ", mar, old, mem[mar]);
                }
    }
    
}
