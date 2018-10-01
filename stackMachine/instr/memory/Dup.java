package stackMachine.instr.memory;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the Dup instruction. This instruction duplicates the top of the stak.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class Dup extends Instr{
         
    /**
      * Constructor a Dup instruction.
      */
     public Dup(int l, int c){ super(l,c);}

     /**
      *Execute the Dup instrction. Pops the top of the stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          st.push(st.top());
          st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
