package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author pcctoo
 */
public class OrTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Or inst = new Or();

    /**
     * this is a test case for the Or instruction.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        int mar = 0;
        mem[mar] = 0xF0F0F0;
        regs[AC] = 0x0F0F0F;
        boolean trace = false;
        Or instance = inst;
        instance.execute(regs, mem, mar , trace);
        System.out.println(regs[AC]);
        assertEquals(regs[AC], 0xFFFFFF);
    }
}
