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
public class SyscTest implements RegisterManipulator {
    
     private final H32 sim = new H32();
     private final Sysc inst = new Sysc();
     
     public SyscTest(){
         
     }
    
     @Test
     public void testExecute(){
          System.out.println("execute");
        int [] regs = sim.getRegs();
        int [] mem = sim.getMem();
        regs[PC] = 15;
        int mar = 15;
        regs[TTB] = 10;
        regs [SP] = 10;
        boolean trace = false;
        Sysc instance = inst;
        instance.execute(regs,mem,mar,trace);
        int result = regs[PC];
        System.out.println(result);
        assertEquals(result,mem[regs[TTB]+mar]);
         
     }
     
     
     
    
}
