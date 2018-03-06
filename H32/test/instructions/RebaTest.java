/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.BP;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class RebaTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Reba inst = new Reba();
    
    public RebaTest(){
        
    }
    
    @Test
    public void testExectue(){
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[SP] = 10;
        regs[BP]= 10;
        int mar = 0;
        boolean trace = false;
        Reba instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[BP];
        assertEquals(result,0);
    }
    
}
