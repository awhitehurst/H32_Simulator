package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class DisiTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Disi inst = new Disi();

    
    public DisiTest() {

    }

    /**
     * Test of execute method, of class Disi.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[INTE] =0;
        regs[ZERO] = 0;
        int mar = 0;
        boolean trace = false;
        Disi instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[INTE];
        assertEquals(result, 0);
    }
}
