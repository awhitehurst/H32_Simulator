package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class AddTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Add inst = new Add();
    
    public AddTest(){
        
    }
    
    /**
     * Test of execute method, of class Add.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 25;
        int mar = 0;
        mem[mar] = 5;
        boolean trace = false;
        Add instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result,30);
        
    }
}
