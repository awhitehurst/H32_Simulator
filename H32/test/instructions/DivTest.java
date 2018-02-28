package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class DivTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Div inst = new Div();

    public DivTest() {

    }

    /**
     * Test of execute method, of class Div.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 16;        
        int mar = 0;
        mem[mar] = 8;
        boolean trace = false;
        Div instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(result, 2);
    }
}
