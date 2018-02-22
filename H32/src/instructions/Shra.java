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
public class Shra implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
                // SHRA X
                // AC = AC >> X (inject sign)
                int mask = 0;
                if (regs[AC] < 0) {
                    mask = 0x80000000;
                }
                for (int i = 0; i < (mar & 0x1F); ++i) {
                    regs[AC] = (regs[AC] >> 1) | mask;
                }
    }
    
}
