package stackMachine.instr.arithmetical;

import stackMachine.instr.Instr;
import stackMachine.MachState;
 import stackMachine.synPrettyPrint.ConcreteSyn;

/** Arithmetical float subtraction instrucion. Repseresent the subtraction on floats.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */
 
public class SubF extends Instr{
     
     public SubF(int l, int c){ super(l,c); }
     
     /** Execute the multiplication operation. 
       * @param st: The machine state.
       */
     public void execute(MachState st){
         st.push( new Float( ((Number)st.pop()).floatValue() - ((Number)st.pop()).floatValue() ));
         st.nextPc();
     }

     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }
}
