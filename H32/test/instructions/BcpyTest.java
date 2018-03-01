/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static h32.RegisterManipulator.AC;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Family Computer
 */
public class BcpyTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Bcpy inst = new Bcpy();

    public BcpyTest() {

    }

    /**
     * Test of execute method, of class Bcpy.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int[] regs = sim.getRegs();
        int[] mem = sim.getMem();
        regs[CT]= 3;
        regs[AC] = 4;
        int mar = 0;
        mem[mar] = 4;
        boolean trace = false;
        Bcpy instance = inst;
        instance.execute(regs, mem, mar, trace);
        int result = mem[regs[AC]];
        System.out.println(result);
        assertEquals(result, null);
    }

}
