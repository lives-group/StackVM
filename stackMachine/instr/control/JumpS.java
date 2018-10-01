package stackMachine.instr.control;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the unconditional Jump instruction. This instruction is similar to the Jump
 * instruction except that in this case the target instruction is also in stak.
 *
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class JumpS extends Instr{
     
     /**
      * Constructor a jump instruction.
      */
     public JumpS(int l, int c){super(l,c); }

     /**
      *Execute te jump to the targt instruction.
      *@param st: The machine state.
      */
      public void execute(MachState st){
          st.setPc((Integer)st.pop());
      }
      
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); } 
     
}
