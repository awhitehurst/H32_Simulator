/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static h32.RegisterManipulator.BP;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class JzTest implements RegisterManipulator{
    
    private final H32 sim = new H32();
    private final Jz inst = new Jz();
    
    public JzTest(){
        
    }
    
    /**
     * Test of execute method, of class Jz.
     */
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[AC] = 0;
        int mar = 15;
        boolean trace = false;
        Jz instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result= regs[PC];
        assertEquals(result,15);
    }
    
}
