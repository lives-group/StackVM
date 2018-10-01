package stackMachine.instr.arithmetical;

/** Arithmetical floating addiction instrucion. Repseresent the addicion instruction on floats.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

import stackMachine.instr.Instr;
import stackMachine.MachState;
 import stackMachine.synPrettyPrint.ConcreteSyn;

public class AddF extends Instr{
     
     public AddF(int l, int c){super(l,c); }
     
     /** Execute the addiction operation. 
      * @param st: The machine state.
      */
     public void execute(MachState st){
         try{ 
           st.push(new Float( ((Number)st.pop()).floatValue() + ((Number)st.pop()).floatValue() ));
         }catch(ClassCastException e){
           
         }
         
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }
}
