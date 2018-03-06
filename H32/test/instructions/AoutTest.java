package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class AoutTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Aout inst = new Aout();

    public AoutTest() {

    }

    /**
     * Test of execute method, of class Aout.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        int mar = 0;
        boolean trace = false;
        Aout instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, null);
    }

}
