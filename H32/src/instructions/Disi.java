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
public class Disi implements Executable{
    // DISI
    // INTE = 0
    

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        regs[INTE] = regs[ZERO];
    }
                
}
