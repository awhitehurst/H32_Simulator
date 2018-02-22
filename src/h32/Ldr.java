/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h32;

/**
 *
 * @author Adrian Sanchez
 */
public class Ldr implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // LDR S
                // AC = MEM[BP+S]
                new Ldr().execute(regs, mem, mar);
    }
    
}
