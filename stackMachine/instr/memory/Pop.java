package stackMachine.instr.memory;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the pop instruction. This instruction discards the top of the stak.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class Pop extends Instr{
         
    /**
      * Constructor a Pop instruction.
      */
     public Pop(int l, int c){super(l,c); }

     /**
      *Execute the pop instrction. Pops the top of the stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          st.pop();
          st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
     
}
