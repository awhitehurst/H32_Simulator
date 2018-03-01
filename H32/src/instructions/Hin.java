
package instructions;

import h32.Executable;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Hin implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        String hexInput = (new Scanner(System.in)).nextLine().toUpperCase();
        int hexNumber = 0;
        for (int i = 0; i < hexInput.length(); ++i) {
            if (Character.isDigit(hexInput.charAt(i))) {
                hexNumber = hexNumber * 16 + (int) (hexInput.charAt(i) - '0');
            } else if(hexInput.charAt(i)>='A' && hexInput.charAt(i)<='F'){
                hexNumber = hexNumber * 16 + (int) (hexInput.charAt(i) - 'A' + 10);
            } else {
                break;
            }
        }
        regs[AC] = hexNumber;
    }

}
