package instructures;

import h32.Executable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alex
 */
public class Enbi implements Executable {
    // ENBI
    // INTE = 1
    

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
       regs[INTE] = regs[ONE];
    }
}
