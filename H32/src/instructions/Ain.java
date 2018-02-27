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
