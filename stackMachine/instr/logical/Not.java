package stackMachine.instr.logical;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

public class Not extends Instr{
     
     public Not(int l, int c){ super(l,c); }
     
     public void execute(MachState st){
         st.push( !((Boolean)st.pop()) );
         st.nextPc();
     }
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }     
}
