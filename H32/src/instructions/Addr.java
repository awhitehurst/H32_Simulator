/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;
import h32.H32;

/**
 *
 * @author pcctoo
 */
public class Addr implements Executable {


    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
                    int OFFSET = 0;
                    long result = (long) regs[AC] + (long) mem[regs[BP] + OFFSET];
                regs[AC] = (int) result;
                if (result > 0xFFFFFFFF) {
                    regs[CY] = 1;
                } else {
                    regs[CY] = 0;
                }
    }
            
}
