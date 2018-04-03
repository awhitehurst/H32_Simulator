package h32;

/**
 * A process encapsulates the running state of a
 * program (or thread)
 * @author Whitehurst
 */
public class Process implements RegisterManipulator {
    
    public enum State { READY, RUNNING, BLOCKED};
    
    private int pid;
    private State state;
    private int[] regs;
    private static final int ROFF = 5;
    
    public Process(int pid){
        this(pid,0);
        
    }
    
    public Process(int pid, int pc){
        this(pid, pc, 0);
    } 
    
    public Process(int pid, int pc, int mb){
        this.pid = pid;
        this.state = State.READY;
        regs = new int[9];
        regs[MDR-ROFF] = 0;
        regs[PC-ROFF] = pc;
        regs[SP-ROFF] = 0x100000;
        regs[AC-ROFF] = 0;
        regs[IR-ROFF] = 0;
        regs[CT-ROFF] = 0;
        regs[CY-ROFF] = 0;
        regs[BP-ROFF] = 0;
        regs[MB-ROFF] = mb;
    }
    
    public void save(int [] processor){
        regs[MDR-ROFF] = processor[MDR];
        // ...
    }
    
    public void restore(int [] processor){
        processor[MDR] = regs[MDR-ROFF];
        // ...
    }
    
}
