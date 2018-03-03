/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Joshua
 */
public class AinTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Ain inst = new Ain();

    public AinTest() {

    }

    /**
     * Test of execute method, of class Ain.
     */
    @Test
    public void testExecute() {
        System.out.println("execute Ain");
        fail("Test manually");
    }

}
