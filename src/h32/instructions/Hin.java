/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructures;

import h32.Executable;
import static java.lang.System.console;

/**
 *
 * @author Alex
 */
public class Hin implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        String hexInput = console.next("[0-9A-Fa-f]+").toUpperCase();
                int hexNumber = 0;
                for (int i = 0; i < hexInput.length(); ++i) {
                    if (Character.isDigit(hexInput.charAt(i))) {
                        hexNumber = hexNumber * 16 + (int) (hexInput.charAt(i) - '0');
                    } else {
                        hexNumber = hexNumber * 16 + (int) (hexInput.charAt(i) - 'A' + 10);
                    }
                    regs[AC] = hexNumber;
                }
    }
    
}
