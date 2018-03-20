
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
public class JnzTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Jnz inst = new Jnz();

    public JnzTest() {

    }

    /**
     * Test of execute method, of class Jnz.
     */
    @Test
    public void testExecute() {
        System.out.println("execute Jnz");
        int[] mem = sim.getMem();
        int[] regs = sim.getRegs();
        int mar = 0;
        regs[AC] = 1;
        boolean trace = false;
        Jnz instance = inst;
        instance.execute(regs, mem, mar, trace);
        int results = regs[PC];
        assertEquals(results, 0);
    }

}
