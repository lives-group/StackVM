package stackMachine.instr.logical;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

public class And extends Instr{
     
     public And(int l, int c){ super(l,c); }
     
     public void execute(MachState st){
         st.push( ((Boolean)st.pop()) && ((Boolean)st.pop()) );
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
