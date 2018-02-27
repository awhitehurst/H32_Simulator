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
 * @author Adrian Sanchez
 */
public class Sin implements Executable {
    

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        // SIN
        // MEM[AC] << console
        String input = (new Scanner(System.in)).nextLine();
        for (int i = 0; i < input.length(); ++i) {
            mem[regs[AC] + i] = input.charAt(i);
        }
        mem[regs[AC] + input.length()] = 0;
    }

}
