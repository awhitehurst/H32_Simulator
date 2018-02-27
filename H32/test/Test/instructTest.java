/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import instructions.Sub;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author Joshua Neilson
 */
public class instructTest {
    
    Sub sub = new Sub();
    int check = sub.execute(3, mem, 2, true);
    int testSub = 1;
 
    @Test
    public void testSub(){
        System.out.println("@Test check(): " + check + " = " + testSub);
        assertEquals(check,testSub);
    }
    
}
