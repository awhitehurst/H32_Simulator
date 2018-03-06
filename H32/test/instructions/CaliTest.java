package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class CaliTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Cali inst = new Cali();

    public CaliTest() {

    }

    /**
     * Test of execute method, of class "".
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 5;
        int mar = 0;
        boolean trace = false;
        Cali instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(regs[AC], regs[PC]);
    }
}
