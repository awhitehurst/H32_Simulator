package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class EsbaTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Esba inst = new Esba();

    public EsbaTest() {

    }

    /**
     * Test of execute method, of class Esba.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[SP] = 4;
        regs[BP] = 2;
        int mar = 0;
        boolean trace = false;
        Esba instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[BP];
        assertEquals(result, 3);
    }
}
