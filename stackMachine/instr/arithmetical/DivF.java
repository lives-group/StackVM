package stackMachine.instr.arithmetical;

/** Arithmetical floating division instrucion. Repseresent the division instruction on floats.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */
 
import stackMachine.instr.Instr;
import stackMachine.MachState;
 import stackMachine.synPrettyPrint.ConcreteSyn;

public class DivF extends Instr{
     
     public DivF(int l, int c){ super(l,c); }
    
    /** Execute the division operation. 
      * @param st: The machine state.
      */
     public void execute(MachState st){
         st.push( new Float( ((Number)st.pop()).floatValue() / ((Number)st.pop()).floatValue() ));
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
