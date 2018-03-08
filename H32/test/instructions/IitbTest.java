
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua Neilson
 */
public class IitbTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Iitb inst = new Iitb();
    
    public IitbTest(){
        
    }
    
    /**
     * Test of execute method, of class Iitb.
     */
    @Test
    public void testExecute(){
        System.out.println("execute Iitb");
        int [] mem = sim.getMem();
        int [] regs = sim.getRegs();
        boolean trace = false;
        int mar = 1;
        Iitb instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[ITB];
        assertEquals(result, 1);
    }
    
}
