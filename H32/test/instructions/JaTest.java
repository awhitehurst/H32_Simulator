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
public class JaTest implements RegisterManipulator{
    
    private final H32 sim = new H32();
    private final Ja inst = new Ja();
    
    public JaTest(){
        
    }
    
    /**
     * Test of execute method, of class Ja.
     */
    
    @Test
    public void testExecute(){
        System.out.println("execute Ja");
        int [] mem = sim.getMem();
        int [] regs = sim.getRegs();
        int mar = 10;
        boolean trace = false;
        Ja instance = inst;
        instance.execute(regs, mem, mar, trace);
        assertEquals(regs[PC],10);
    }
    
}
