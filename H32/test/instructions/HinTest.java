
package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Joshua Neilson
 */
public class HinTest implements RegisterManipulator{

    private final H32 sim = new H32();
    private final Hin inst = new Hin();

    public HinTest() {

    }

    /**
     * Test of execute method, of class Hin.
     */
    @Test
    public void testExecute() {
        System.out.println("execute Hin");
        fail("Test manually");
    }

}
