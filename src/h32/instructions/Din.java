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
public class Din implements Executable {
               

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        regs[AC] = console.nextInt();
    }
}
                
