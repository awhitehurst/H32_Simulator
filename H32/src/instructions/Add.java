package instructions;

import h32.Executable;
import h32.H32;
import static h32.H32.*;
import static h32.RegisterManipulator.CY;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pcctoo
 */
public class Add implements Executable {

    // case 0x02:
    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        //AC = AC + mem{X}; CY = CARRY
        long result = (long) regs[AC] + (long) mem[mar];
        regs[AC] = (int) result;
        if (result > 0xFFFFFFFFL) {
            regs[CY] = 1;
        } else {
            regs[CY] = 0;
        }
    }

}