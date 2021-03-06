package stackMachine.instr.logical;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

public class Lt extends Instr{
     
     public Lt(int l, int c){super(l,c); }
     
     public void execute(MachState st){
         st.push( ((Number)st.pop()).doubleValue() < ((Number)st.pop()).doubleValue() );
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
