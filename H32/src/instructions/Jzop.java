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
public class Jzop implements Executable{
     // JZOP X
                // if(AC>=0) PC = X;
               

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
      if (regs[AC] >= 0) {
                    regs[PC] = mar;}
    }
}
