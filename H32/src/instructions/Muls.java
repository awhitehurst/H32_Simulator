/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Muls implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // STR S
                // AC = MEM[BP+S]
                int old = mem[regs[BP] + OFFSET];
                mem[regs[BP] + OFFSET] = regs[AC];
                if (trace) {
                    System.out.printf("MEM[%08X]=%08X/%08X; ", mar, old, mem[mar]);
                }
    }
    
}
