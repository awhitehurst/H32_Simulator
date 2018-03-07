
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author pcctoo
 */
public class JnzTest implements RegisterManipulator {
     private final H32 sim = new H32();
    private final Jnz inst = new Jnz();
    
    public JnzTest(){
        //this is a test of the jnz opcode
    }
 @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 3;
        int mar = 1;
        boolean trace = false;
       Jnz instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result = regs[PC];
        System.out.println(result);
        assertEquals(result,1);
        
    }
    
}
     
