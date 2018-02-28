package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class DlocTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Dloc inst = new Dloc();

    public DlocTest() {

    }

    /**
     * Test of execute method, of class Dloc`.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[SP] = 5;
        int mar = 4;
        boolean trace = false;
        Dloc instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[SP];
        assertEquals(result, 9);
    }
}
