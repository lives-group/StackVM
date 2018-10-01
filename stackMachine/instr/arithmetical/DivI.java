package stackMachine.instr.arithmetical;

/** Arithmetical intetger division instrucion. Repseresent the division instruction on integers.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */
 
import stackMachine.instr.Instr;
import stackMachine.MachState;
 import stackMachine.synPrettyPrint.ConcreteSyn;

public class DivI extends Instr{
     
     public DivI(int l, int c){ super(l,c); }
     
     /** Execute the division operation. 
       * @param st: The machine state.
       */
     public void execute(MachState st){
         st.push( new Integer( ((Number)st.pop()).intValue() / ((Number)st.pop()).intValue() ));
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
