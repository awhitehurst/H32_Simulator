package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author pcctoo
 */
public class OrTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Or inst = new Or();

    public OrTest() {

    }
    /**
     * this is a test case for the Or instruction.
     */
 public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
    
        mem [regs[SP]] = 5;
        boolean trace = false;
       Or instance = inst;
    instance.execute(regs,mem,PC,trace);
        int result = regs[PC];
        System.out.println(result);
        assertEquals(result,5);
}
}
