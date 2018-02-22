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
public class Sysc implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // SYSC X
                // MEM[SP--] = PC; PC = MEM[TTB + X]
                mem[regs[SP]--] = regs[PC];
                regs[PC] = mem[regs[TTB] + mar];
    }
    
}
