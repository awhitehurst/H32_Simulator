/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Ldr implements Executable {
       // LDR S
                // AC = MEM[BP+S]
           

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        int old = regs[AC];
        int OFFSET = 0;
                regs[AC] = mem[regs[BP] + OFFSET];
    }
               
}
