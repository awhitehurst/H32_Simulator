package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Whitehurst
 */
public class StTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final St inst = new St();
    
    public StTest() {
    }

    /**
     * Test of execute method, of class St.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem=sim.getMem();
        regs[AC] = 1;
        int mar = 0;
        boolean trace = false;
        St instance = new St();
        instance.execute(regs, mem, mar, trace);
        int result = mem[0];
        assertEquals(result, 1);
    }
    
}
