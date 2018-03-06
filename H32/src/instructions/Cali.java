package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Cali implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // CALI
        // MEM[--SP] = PC;PC = AC
        mem[--regs[SP]] = regs[PC];
        regs[PC] = regs[AC];
    }
}
