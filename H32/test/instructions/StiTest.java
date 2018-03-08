
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author pcctoo
 */
public class StiTest implements RegisterManipulator{
    private final H32 sim = new H32();
    private final Sti inst = new Sti();
    
    public StiTest(){
        
    }
    
    /**
     * Test of execute method, of class sti.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        mem [regs[SP]] = 5;
        boolean trace = false;
        Sti instance = inst;
        instance.execute(regs,mem,PC,trace);
        int result = regs[PC];
        System.out.println(result);
        assertEquals(result,5);
        
    }
    
}
