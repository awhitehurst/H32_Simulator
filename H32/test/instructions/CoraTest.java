package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class CoraTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Cora inst = new Cora();

    public CoraTest() {

    }

    /**
     * Test of execute method, of class cora.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 5;
        regs[BP]= 10;
        int mar = 0;
        boolean trace = false;
        Cora instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(result, 15);
    }
}
