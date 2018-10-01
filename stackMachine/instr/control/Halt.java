package stackMachine.instr.control;

/** Repseresent the halt instruction. This instruction cause the machine to stop slecting new instrunctions for execution.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

public class Halt extends Instr{
     
     /**
      * Constructor a halt instruction.
      */
     public Halt(int l, int c){ super(l,c); }
     
     /**
      * Execute method. Stop updateing the pc.
      * @param st: The machine state. 
      */
     public void execute(MachState st){ st.halt(); }
     
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }
}
