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
public class AddcTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Addc inst = new Addc();
    
    public AddcTest(){
        
    }
    
    /**
     * Test of execute method, of class Addc.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 5;
        int mar = 5;
        boolean trace = false;
        Addc instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result,10);
        
    }
    
}
