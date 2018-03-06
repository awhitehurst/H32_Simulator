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
 * @author Adrian Sanchez
 */
public class ShraTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Shll inst = new Shll();
    
    public ShraTest(){
        
    }
    
    /**
     * Test of execute method, of class Ret.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 0;
        boolean trace = false;
        Shll instance = inst;
        instance.execute(regs,mem,AC,trace);
        int result = regs[AC];
        System.out.println(result);
        assertEquals(result,0);
        
    }
    
} 