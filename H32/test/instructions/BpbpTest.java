package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class BpbpTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Bpbp inst = new Bpbp();

    public BpbpTest() {

    }

    /**
     * Test of execute method, of class Bpbp.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();        
        int mar = 0;        
        Bpbp instance = inst;
        int expValue =mem[regs[BP]];
        instance.execute(regs, mem, mar, false);
        int result = regs[BP];        
        assertEquals(result, expValue);

    }

}
