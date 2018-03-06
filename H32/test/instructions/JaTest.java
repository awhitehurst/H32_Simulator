/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
<<<<<<< HEAD
import static h32.RegisterManipulator.PC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class JaTest implements RegisterManipulator {
=======

/**
 *
 * @author Joshua Neilson
 */
public class JaTest implements RegisterManipulator{
>>>>>>> 5728e97a15853dbe9e734381f30a865a41c3d75c
    
    private final H32 sim = new H32();
    private final Ja inst = new Ja();
    
<<<<<<< HEAD
    public JaTest(){
        
    }
    
    @Test
    public void testExecute(){
        System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[PC] = 5;
        int mar = 5;
        boolean trace = false;
        Ja instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result= regs[PC];
        assertEquals(result,5);
    }
=======
>>>>>>> 5728e97a15853dbe9e734381f30a865a41c3d75c
}
