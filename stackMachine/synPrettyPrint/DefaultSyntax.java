package stackMachine.synPrettyPrint;

/** Concrete Syntax for instructions. This class implements the convertion of each 
 *  instruction to a string using the default syntax provided with. 
 *  If the default concrete syntax (lexer and parser) is altered
 *  please do create another instance of this class that defines the names of the isntructions
 *  to the new syntax. This class can be used as a model to create new concrete sybtaxes.
 * UFOP/DECSI
 * @author Elton M. Cardoso
 * @version 0.1
 */

import stackMachine.instr.arithmetical.*; 
import stackMachine.instr.logical.*; 
import stackMachine.instr.control.*; 
import stackMachine.instr.memory.*; 
import stackMachine.instr.io.*;

public class DefaultSyntax implements ConcreteSyn{

    public String pPrint(AddF i){ return "addf"; }
    public String pPrint(AddI i){ return "addi"; }
    public String pPrint(SubF i){ return "subf"; }
    public String pPrint(SubI i){ return "subi"; }
    public String pPrint(DivF i){ return "divf"; }
    public String pPrint(DivI i){ return "divi"; }
    public String pPrint(MultI i){ return "multi"; }
    public String pPrint(MultF i){ return "multf"; }
    
    public String pPrint(Jump i)  { return "jump "  + i.getTarget();}
    public String pPrint(JumpT i) { return "jumpt " + i.getTarget();}
    public String pPrint(JumpS i) { return "jumps" ;}
    public String pPrint(JumpST i){ return "jumpst";}
    
    public String pPrint(And i){ return "and";}
    public String pPrint(Not i){ return "not";}
    public String pPrint(Or i) { return "or";}    
    public String pPrint(Eq i) { return "eq";}
    public String pPrint(Gt i) { return "gt";}
    public String pPrint(Lt i) { return "lt";}

    public String pPrint(Push i) { return "push " + i.getConst().toString(); }
    public String pPrint(Pop i)  { return "pop";}
    public String pPrint(Dup i)  { return "dup";}
    public String pPrint(Load i) { return "load";}
    public String pPrint(Store i){ return "store";}
    public String pPrint(Halt i) { return "halt";}
    
    public String pPrint(Get i) { return "getch";}
    public String pPrint(Put i) { return "putch";}    
    
    public String pPrint(Pc i)   { return "pc"; }
    
    
}
