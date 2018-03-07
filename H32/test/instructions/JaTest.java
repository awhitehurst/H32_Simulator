
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.PC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
<<<<<<< HEAD
 * @author Alex
 */
public class JaTest implements RegisterManipulator {

=======
 * @author Joshua Neilson
 */
public class JaTest implements RegisterManipulator{
>>>>>>> b39c5949ce26b49842d173979147f9cd47172204

    
    private final H32 sim = new H32();
    private final Ja inst = new Ja();
    
<<<<<<< HEAD
    public JaTest(){
        
    }
=======
>>>>>>> b39c5949ce26b49842d173979147f9cd47172204
    
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
