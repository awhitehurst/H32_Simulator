package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static h32.RegisterManipulator.BP;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class AddyTest implements RegisterManipulator{
    
    private final H32 sim = new H32();
    private final Addy inst = new Addy();

    public AddyTest() {

    }

    /**
     * Test of execute method, of class Addy.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 20;
        regs[CY] = 1;
        int mar = 3;
        mem[mar] = 6;
        boolean trace = false;
        Addy instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, 27);
    }
    
}
