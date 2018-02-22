/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;
import h32.H32;
import static h32.RegisterManipulator.PC;

/**
 *
 * @author pcctoo
 */
public class Dect implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
           regs[CT] = regs[CT] - regs[ONE];
                if (regs[CT] == 0) {
                    regs[PC] = regs[PC] + 1;
    }

             
    }
}
