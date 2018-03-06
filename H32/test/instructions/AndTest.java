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
public class AndTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final And inst = new And();

    public AndTest() {

    }

    /**
     * Test of execute method, of class And.
     */
    @Test
    public void testExecute() {
        System.out.println("execute AND");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 0;
        int mar = 8;
        mem[mar] = 6;
        boolean trace = false;
        And instance = inst;
        System.out.println("\texecute AND (0 & 6)");
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, 0);
        regs[AC] = 0xFF;
        mem[mar] = 0xF;
        System.out.println("\texecute AND (255 & 15)");
        instance.execute(regs, mem, mar, trace);
        assertEquals(regs[AC], 0xF);
    }

}
