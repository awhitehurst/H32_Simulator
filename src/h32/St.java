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
public class St implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // ST X
        // MEM[x] = AC
        int old = mem[mar];
        mem[mar] = regs[AC];
        if (trace) {
            System.out.printf("  MEM[%08X]=%08X/%08X; ", mar, old, mem[mar]);
        }
    }
    

}
