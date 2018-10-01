package stackMachine.instr.arithmetical;

/** Arithmetical integer multiplication instrucion. Repseresent the multiplication on integers.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */
 
import stackMachine.instr.Instr;
import stackMachine.MachState;
 import stackMachine.synPrettyPrint.ConcreteSyn;

public class MultI extends Instr{
     
     public MultI(int l, int c){ super(l,c); }
     
     /** Execute the multiplication operation. 
       * @param st: The machine state.
       */
     public void execute(MachState st){
         st.push( new Integer( ((Number)st.pop()).intValue() * ((Number)st.pop()).intValue() ));
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
