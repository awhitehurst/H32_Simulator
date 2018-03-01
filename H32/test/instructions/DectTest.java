package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class DectTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Dect inst = new Dect();

    public DectTest() {

    }

    /**
     * Test of execute method, of class Dect.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[CT] = 1;
        regs[ONE] = 1;
        regs[PC] = 0;
        int mar = 0;
        boolean trace = false;
        Dect instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[PC];
        System.out.println(result);
        assertEquals(result,1);

    }
}
