package stackMachine.synPrettyPrint;

/** Concrete Syntax for instructions. This interface defines the convertion of each 
 *  instruction to a string. If the default concrete syntax (lexer and parser) is altered
 *  please do create a instance of this class that defines the names of the isntructions
 *  to the new syntax. This is to keep error messages coherent with the concrete syntax. 
 *
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 */

import stackMachine.instr.arithmetical.*; 
import stackMachine.instr.logical.*; 
import stackMachine.instr.control.*; 
import stackMachine.instr.memory.*; 
import stackMachine.instr.io.*; 
import stackMachine.instr.Instr; 

public interface ConcreteSyn{

    public String pPrint(AddF i);
    public String pPrint(AddI i);
    public String pPrint(SubF i);
    public String pPrint(SubI i);
    public String pPrint(DivF i);
    public String pPrint(DivI i);
    public String pPrint(MultI i);
    public String pPrint(MultF i);
    
    public String pPrint(Jump i);
    public String pPrint(JumpT i);
    public String pPrint(JumpS i);
    public String pPrint(JumpST i);
    
    public String pPrint(And i);
    public String pPrint(Not i);
    public String pPrint(Or i);    
    public String pPrint(Eq i);
    public String pPrint(Gt i);
    public String pPrint(Lt i);

    public String pPrint(Push i);
    public String pPrint(Pop i);
    public String pPrint(Dup i);
    public String pPrint(Load i);
    public String pPrint(Store i);
    public String pPrint(Halt i);
    
    public String pPrint(Get i);
    public String pPrint(Put i);
    
    public String pPrint(Pc i);
    
    
}
