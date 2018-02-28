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
public class StrTest implements RegisterManipulator  {
    
    private final H32 sim = new H32();
    private final Str inst = new Str();
    
    public StrTest(){
        
    }
    
    /**
     * Test of execute method, of class Str.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 15;
        regs[BP] = 8;
        int mar = 4;
        boolean trace = false;
        Str instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result= mem[regs[BP]+mar];
        assertEquals(result,15);
    }
    
}
