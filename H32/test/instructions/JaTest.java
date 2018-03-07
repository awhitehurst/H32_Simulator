
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.PC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class JaTest implements RegisterManipulator {


    
    private final H32 sim = new H32();
    private final Ja inst = new Ja();
    
    public JaTest(){
        
    }
    
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[PC] = 5;
        int mar = 5;
        boolean trace = false;
        Ja instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result= regs[PC];
        assertEquals(result,5);
    }

}
