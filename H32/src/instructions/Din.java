/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;




/**
 *
 * @author Alex
 */
public class Din implements Executable {
               

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        regs[AC] = console.nextInt();
    }
}
                
