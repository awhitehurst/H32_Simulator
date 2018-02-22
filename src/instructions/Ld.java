package instructions;


import h32.Executable;


/**
 * The load instruction. Instruction form: LD X <br>Results: AC = MEM[x]
 *
 * @author Whitehurst
 */
public class Ld implements Executable {

    /**
     * Instruction form: LD X <br>Results: AC = MEM[x]
     * @param regs
     * @param mem
     * @param mar
     */
    public void execute(int[] regs, int[] mem, int mar) {
        regs[AC] = mem[mar];
    }

}
