package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class CallTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Call inst = new Call();

    public CallTest() {

    }

    /**
     * Test of execute method, of class call.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[SP] = 5;
        regs[PC] = 8;
        int mar = 25;
        boolean trace = false;
        Call instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = mem[regs[SP]];
        int result2 = regs[PC];
        System.out.println(result);
        System.out.println(result2);
        assertEquals(result, 8);
        assertEquals(result2,25);
    }
}
