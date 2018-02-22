/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;
import h32.H32;
import static h32.H32.AC;
import static h32.H32.BP;

/**
 *
 * @author pcctoo
 */
public class Ldr implements Executable {
       // LDR S
                // AC = MEM[BP+S]
           

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        int old = regs[AC];
        int OFFSET = 0;
                regs[AC] = mem[regs[BP] + OFFSET];
    }
               
}
