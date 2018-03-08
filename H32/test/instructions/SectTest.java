/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class SectTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Sect inst = new Sect();
    
    public SectTest(){
        
    }
    
    @Test
    public void testExecute(){
         System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[CT] = 5;
        int mar = 0;
        boolean trace = false;
        Sect instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[CT];
        assertEquals(result,0);
    }
    
}
