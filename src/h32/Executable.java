package h32;

/**
 * Classes implementing this interface are executable instructions
 * in the H32 Instruction Set.
 * 
 * @author Whitehurst
 */
public interface Executable extends RegisterManipulator {
    
    public void execute(int [] regs, int [] mem, int mar);
    
}
