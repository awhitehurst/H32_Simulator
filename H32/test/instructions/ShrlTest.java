/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class ShrlTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Shrl inst = new Shrl();
    
    public ShrlTest() {
        
    }
    
    @Test
    public void testExecute(){
         System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 5;
        int mar = 0;
        boolean trace = false;
         Shrl instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = regs[AC];
        assertEquals(result,regs[AC] >> (mar & 0x1F));
    }
    
}
