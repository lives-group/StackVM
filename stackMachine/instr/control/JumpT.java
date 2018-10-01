package stackMachine.instr.control;

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

/** Repseresent the conditional Jump instruction. The instruction is parametrized
 * by addres to jump to in the program memory. The jump will only occur if the top
 * of the stak contains a true boolean value.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

public class JumpT extends Instr{
     
     private int target;
     
     /**
      * Constructor a jump instruction.
      * @param d: The address, in the program memory, to jump to. 
      */
     public JumpT(int l, int c,int d){super(l,c); target = d; }

     /**
      *Execute te jump to the targt instruction, only if true is on top of stack.
      *@param st: The machine state.
      */
     public void execute(MachState st){
          if((Boolean)st.pop()){st.setPc(target);}
          else{st.nextPc();}
     }
    
    /**
      *@return The target (address) of this instruction.
      */
     public int getTarget(){ return target;}
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }   
     
     public void setTarget(int d){ target = d;}
}
