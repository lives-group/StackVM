package stackMachine.instr.control;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the conditional Jump instruction. This instruction is similar to the JumpT
 * instruction except that in this case the target instruction is also in stak.
 *
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class JumpST extends Instr{
     
     /**
      * Constructor a jump instruction.
      */
     public JumpST(int l, int c){super(l,c); }

     /**
      *Execute te jump to the targt instruction, only if true is on top of stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          if((Boolean)st.pop()){ 
              st.setPc((Integer)st.pop());
          }
          else{st.nextPc();}
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }
     
}
