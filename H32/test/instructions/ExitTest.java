package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static h32.RegisterManipulator.CY;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua Neilson
 */
public class ExitTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Exit inst = new Exit();
    
    public ExitTest(){
        
    }
    
    /**
     * Test of execute method, of class Exit.
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
        Exit instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result, 27);
    }
}
