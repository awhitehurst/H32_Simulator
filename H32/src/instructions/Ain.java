/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;
import java.util.Scanner;

/**
 *
 * @author pcctoo
 */
public class Ain implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // AIN
        // AC << (char) console
        regs[AC] = (new Scanner(System.in)).nextLine().charAt(0);

    }

}
