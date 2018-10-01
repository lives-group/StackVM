package stackMachine.instr.memory;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the store instruction. This instruction stores an value, from the top of the stack,  to a given memory cell.
 * The value is not poped from the stack. The address of memory to be writte shoul be at the top of the stack, followed by
 * value to be stored.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class Store extends Instr{
     
     /**
      * Constructor a load instruction.
      */
     public Store(int l, int c){super(l,c);}

     /**
      *Execute the store instrction. The address is poped from the top of the stack, then tha valye is readed
      * readed from tha top of the stack and stored at the given address. The value is not poped from the stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          int add = (Integer)st.pop();
          Object o = st.top();
          st.writeMem(add,o);
          st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }  
}
