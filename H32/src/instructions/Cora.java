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
 */public class Cora implements Executable {

    @Override
    public void execute(int[] reg, int[] mem, int mar, boolean trace) {
         reg[AC] = reg[AC] + reg[BP];
    }
                
}
