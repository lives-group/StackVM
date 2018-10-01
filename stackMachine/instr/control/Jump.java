package stackMachine.instr.control;

/** Repseresent the unconditional Jump instruction. The instruction is parametrized
 * by addres to jump to in the program memory.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */

import stackMachine.instr.Instr;
import stackMachine.MachState;
import stackMachine.synPrettyPrint.ConcreteSyn;

public class Jump extends Instr{
     
     private int target;
     /**
      * Constructor a jump instruction.
      * @param d: The address, in the program memory, to jump to. 
      */
     public Jump(int l, int c,int d){ super(l,c); target = d; }
     
     /**
      * Execute method. Cause the pc to be set to the targeted instruction.
      * @param st: The machine state. 
      */
     public void execute(MachState st){ st.setPc(target); }
     
     /**
      *@return The target (address) of this instruction.
      */
     public int getTarget(){ return target;}
     
     public String pPrint(ConcreteSyn s){ return s.pPrint(this); }
     
     public void setTarget(int d){ target = d;}
}
