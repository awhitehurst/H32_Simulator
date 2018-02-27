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
public class Reba implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // REBA
                // SP = BP;BP=MEM[SP++]
                regs[SP] = regs[BP];
                regs[BP] = mem[regs[SP]++];
    }
    
}