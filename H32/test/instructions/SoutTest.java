package instructions;

import h32.H32;
import h32.RegisterManipulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author pcctoo
 */
public class SoutTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Sout inst = new Sout();

    public SoutTest() {

    }

    /**
     * Test the sout opcode.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        fail("Test manually");

    }
}
