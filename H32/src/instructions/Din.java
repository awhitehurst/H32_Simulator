
package instructions;

import h32.Executable;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Din implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar, boolean trace) {
        String intInput = (new Scanner(System.in)).nextLine().toUpperCase();
        int intNumber = 0;
        for (int i = 0; i < intInput.length(); ++i) {
            if (Character.isDigit(intInput.charAt(i))) {
                intNumber = intNumber * 10 + (int) (intInput.charAt(i) - '0');
            } else {
                break;
            }
        }
        regs[AC] = intNumber;
    }

}
