package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class AlocTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Aloc inst = new Aloc();

    public AlocTest() {

    }

    /**
     * Test of execute method, of class Aloc.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[SP] = 10;
        int mar = 5;
        boolean trace = false;
        Aloc instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[SP];
        System.out.println(result);
        assertEquals(result,5);
    }

}
