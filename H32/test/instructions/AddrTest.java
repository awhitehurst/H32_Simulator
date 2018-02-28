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
public class AddrTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Addr inst = new Addr();

    public AddrTest() {

    }

    /**
     * Test of execute method, of class Addr.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 20;
        regs[BP] = 6;
        int mar = 3;
        mem[regs[BP] + mar] = 6;
        boolean trace = false;
        Addr instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, 26);
    }
    
}
