/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class UoutTest implements RegisterManipulator {
    
    private final H32 sim = new H32();
    private final Uout inst = new Uout();
    
    public UoutTest(){
        
    }
    
    @Test
    public void testExecute(){
         System.out.println("execute Uout");
        fail("Test manually");
    }
}
