package stackMachine.instr.memory;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the push (constant load) instruction. This instruction pushes a constant value to the stack.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class Push extends Instr{
     
    private Object cons;
      
    /**
      * Constructor a Push instruction.
      * @param o: The value of the constant.
      */
     public Push(int l, int c, Object o){ super(l,c); cons = o; }

     /**
      *Execute the push instrction. Pushes the constant to the stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          st.push(cons);
          st.nextPc();
     }
     
     /** 
      * @return The constant of this instruction;
      */
     public Object getConst(){ return cons;}
     
     public void setConst(Object o){ cons = o;}
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
