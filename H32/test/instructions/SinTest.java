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
public class SinTest implements RegisterManipulator {

    private final H32 sim = new H32();
    private final Sin inst = new Sin();

    public SinTest() {

    }

    /**
     * a test for the sin opcode
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        fail("Test manually");
    }
}
