/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import static com.sun.javafx.animation.TickCalculation.sub;
import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Adrian Sanchez
 */
public class SubTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Sub inst = new Sub();
    
    public SubTest(){
        
    }
    
    /**
     * Test of execute method, of class Swap.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 10;
        int mar = 10;
        boolean trace = false;
        Sub instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result,10);
        
    }
    
}
     
    

