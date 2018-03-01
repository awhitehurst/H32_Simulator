package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua Neilson
 */
public class HaltTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Halt inst = new Halt();

    public HaltTest() {

    }

    /**
     * Test of execute method, of class Flip.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = -2;
        int mar = 0;
        boolean trace = false;
        Halt instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, null);
    }
    
}
