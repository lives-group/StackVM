package stackMachine.instr.memory;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the pc instruction. This instruction reads the current value of the pc and pushes to the top
 * of the stack.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class Pc extends Instr{
     
     
    /**
      * Constructor a Const instruction.
      * @param o: The value of the constant.
      */
     public Pc(int l, int c){super(l,c);}

     /**
      *Execute the Pc instrction.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          int i = st.readPc();
          st.push(i);
          st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
