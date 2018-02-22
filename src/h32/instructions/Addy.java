/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructures;

import h32.Executable;

/**
 *
 * @author Alex
 */
public class Addy implements Executable {
    
    public void execute(int[] regs, int[] mem, int mar){
    
    // ADDY X
    // AC = AC + MEM[X] + CY;CY = carry
     long result = (long) regs[AC] + (long) mem[mar] + (long) regs[CY];           
     regs[AC] = (int) result;
     if (result > 0xFFFFFFFF) {
     regs[CY] = 1;
     } else {
     regs[CY] = 0;
     }
    }
}
