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
public class Shrl implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
                // SHRL X
                // AC = AC >> X (inject 0's)
                regs[AC] = regs[AC] >> (mar & 0x1F);
    }
    
}
