package stackMachine.instr.memory;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the load instruction. This instruction loads an value from a given the memory cell.
 * The value is pushed into the stack. The address of memory to be reade shoul be at the top of the stack.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class Load extends Instr{
     
     /**
      * Constructor a load instruction.
      */
     public Load(int l, int c){ super(l,c);}

     /**
      *Execute the load instrction. The memory at the given address is readed and tha value
      *is placed at the top of the stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          int add = (Integer)st.pop();
          Object o = st.readMem(add); 
          st.push(o);
          st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
