/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;

/**
 *
 * @author pcctoo
 */
public class Aout implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // AOUT
        // console << (char) AC
        System.out.printf("%c", regs[AC]);
    }

}
