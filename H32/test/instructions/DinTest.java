package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class DinTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Din inst = new Din();

    public DinTest() {

    }

    /**
     * Test of execute method, of class Din.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        int mar = 0;
        boolean trace = false;
        Din instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(result, null);

    }
}
