package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static h32.RegisterManipulator.CY;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua Neilson
 */
public class ExitTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Exit inst = new Exit();

    
    /**
     * Test of execute method, of class Exit.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        int mar = 0;
        boolean trace = false;
        Exit instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(result, 0);
    }
}
