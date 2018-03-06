
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
public class BcpyTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Bcpy inst = new Bcpy();

    public BcpyTest() {

    }

    /**
     * Test of execute method, of class Bcpy.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        mem[0]=1;
        mem[1]=2;
        mem[2]=3;
        regs[CT]= 3;
        regs[AC] = 4;
        int mar = 0;
        boolean trace = false;
        Bcpy instance = inst;
        instance.execute(regs, mem, mar, trace);
        assertEquals(mem[4], 1);
        assertEquals(mem[5], 2);
        assertEquals(mem[6], 3);
    }

}
