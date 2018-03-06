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
public class XorTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Xor inst = new Xor();
    
    public XorTest(){
        
    }
    
    @Test
    public void testExecute(){
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[AC] = 1;
        int mar = 0;
        boolean trace = false;
        Xor instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = ~regs[AC];
        System.out.println(result);
        assertEquals(result,-2);
    }
}
