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
public class LdTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Ld inst = new Ld();

    public LdTest() {

    }

    /**
     * Test of execute method, of class Ld.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 10;
        int mar = 3;
        mem[mar] = 6;
        boolean trace = false;
        Ld instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, 6);
    }

}
