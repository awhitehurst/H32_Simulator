package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class EnbiTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Enbi inst = new Enbi();

    public EnbiTest() {

    }

    /**
     * Test of execute method, of class Enbi.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem(); 
        regs[ONE] = 1;
        int mar = 0;        
        boolean trace = false;
        Enbi instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[INTE];        
        assertEquals(result, 1);
    }
}
