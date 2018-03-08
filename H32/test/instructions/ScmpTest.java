package instructions;

import h32.H32;
import h32.RegisterManipulator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Whitehurst
 */
public class ScmpTest implements RegisterManipulator {
    private final H32 sim = new H32();
    private final Scmp inst = new Scmp();
    
    
    public ScmpTest() {
        
    }
    
    @Test
    public void testExecute(){
        System.out.println("execute Scmp");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        int mar = 0;
        boolean trace = false;
        
        Scmp instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(result,0);
    }
    
}
