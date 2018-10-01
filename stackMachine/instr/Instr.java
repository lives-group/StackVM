package stackMachine.instr;

/** Instruction representation. Each stack machine instruction will be inherited 
 *  from this class. Each instruction is required to implement the execute method 
 *  which can  potentially modify the state. Each instruction is also responsible 
 *  for updating the PC (next instruction pointer). Each instruction keeps the 
 *  information of line and column of the file they came from. Those pieces of 
 *  informations are used to display error messages to the user.
 * 
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 * 
 */
 import stackMachine.MachState;
 import stackMachine.synPrettyPrint.ConcreteSyn;
 
public abstract class Instr{
     
     private int l,c;
     
     
     /** Constrution for instructions. All instructions must contain, at least, 
      *  the line ando column coordintes in their origin file.
      *  @param line: An intger that referes to the instruction's line in the source file.
      *  @param col: An intger that referes to the instruction's column in the source file.
      */
     public Instr(int line,int col){ 
        this.l = line;
        this.c = col;
     }
     
     /** Returns the line of this instruction in the source file. 
      * @return  the line of this instruction in the source file
      */
     public int getLine(){return l;}
     
     /** Returns the column of this instruction in the source file. 
      * @return  the column of this instruction in the source file
      */
     public int getColumn(){return c;}
     
    /** execute this instruction on the current state.
     *  This method defines the behavior (or semantics) of the instruction. Classes inherited
     *  from this classes must overrited this method accordiling to inted semantics of the defined instruction.
     *  @param st: The current state of the machine. @see stackMachine.MachState
     */
     public abstract void execute(MachState st);
     
     /**
      *Pretty Print for instructions.
      * @param s: A definition for the concrete suntax
      * @return A string containing the concrete syntax representaion fo this instruction.
      */
     public abstract String pPrint(ConcreteSyn s);
     
}
