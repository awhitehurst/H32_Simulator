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
 * @author Joshua Neilson
 */
public class IttbTest implements RegisterManipulator{
    
    private final H32 sim = new H32();
    private final Ittb inst = new Ittb();
    
    public IttbTest(){
        
    }
    
    /**
     * Test of execute method, of class Ittb.
     */
    @Test
    public void testExecute(){
        System.out.println("execute Ittb");
        int [] mem = sim.getMem();
        int [] regs = sim.getRegs();
        boolean trace = false;
        int mar = 3;
        Ittb instance = inst;
        instance.execute(regs, mem, mar, trace);
        int results = regs[TTB];
        assertEquals(results,3);
    }
    
}
