
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Adrian Sanchez
 */
public class SwapTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Swap inst = new Swap();
    
    public SwapTest(){
        
    }
    
    /**
     * Test of execute method, of class Swap.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 15;
        int mar = 15;
        regs[TMP] = 10;
        regs [SP] = 10;
        boolean trace = false;
        Swap instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result,10);
        
    }
    
}
    

