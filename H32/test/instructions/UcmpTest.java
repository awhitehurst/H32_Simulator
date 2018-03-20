package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class UcmpTest implements RegisterManipulator{
    
    private final H32 sim = new H32();
    private final Ucmp inst = new Ucmp();
    
    public UcmpTest(){
        
    }
    
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        int mar = 0;
        boolean trace = false;
        Ucmp instance = inst;
        instance.execute(regs, mem, mar, trace);
        assertEquals(regs[AC],null);
    }
    
    
    
}
