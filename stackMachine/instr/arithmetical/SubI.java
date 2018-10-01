package stackMachine.instr.arithmetical;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;
 
/** Arithmetical integer subtraction instrucion. Repseresent the subtraction on integer.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */
 
public class SubI extends Instr{
     
     public SubI(int l, int c){ super(l,c); }
     
     /** Execute the multiplication operation. 
       * @param st: The machine state.
       */
     public void execute(MachState st){
         st.push( new Integer( ((Number)st.pop()).intValue() - ((Number)st.pop()).intValue() ));
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
