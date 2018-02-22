/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Subr implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // SUBR S
        // AC = AC - MEM[BP + S]
        int OFFSET = 0;
        if ((mar & 0x800000) == 0x800000) {
            OFFSET = ((~mar & 0xFFFFFF) + 1) * -1;
        } else {
            OFFSET = mar;
        }
        regs[AC] -= mem[regs[BP] + OFFSET];
    }

}
