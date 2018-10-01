package stackMachine.parser;

import java.util.ArrayList;
import stackMachine.instr.Instr;
import stackMachine.instr.arithmetical.*;
import stackMachine.instr.control.*;
import stackMachine.instr.logical.*;
import stackMachine.instr.memory.*;
import stackMachine.instr.io.*;
import stackMachine.LabelsMap;
import java.util.Hashtable;

%%

%class StkmScanner
%function nextToken
%type Instr
%yylexthrow Exception
%eofval{
         hasNext = false;
         return null;
%eofval}
%unicode
%line
%column
%apiprivate
%{       
        private String str;
        private int cCount = 0;
        private boolean hasNext;
        private ArrayList<Instr> prog;
        private LabelsMap m;
        private Hashtable<String,ArrayList<Integer>> pends;
        private int ic;
        
	private boolean hasNext(){return hasNext;}
	
	public Instr[] readPog(){
	    ic =0;
	    m.clear();
	    prog.clear();
	    pends.clear();
	    ArrayList<Instr> prog = new ArrayList<>();
	    pends = new Hashtable<String,ArrayList<Integer>>();
	    Instr i;
	    try{
 	       i = nextToken();
 	       while(i != null){
	          prog.add(i);
	          i = nextToken();
	       }
	    }catch(Exception e){
	       
	       e.printStackTrace();
	       System.out.println("Error on scanning the input. Aborting.");
	       return null;
	    }
	    Instr[] r = new Instr[2];
	    return prog.toArray(r);
	}
	
	private void declareLabel(String s){
	   m.put(s,ic);
	   ArrayList<Integer> pnd = pends.get(s);
	   if(pnd != null){
	      for(int  i =0; i < pnd.size(); i++){
	         if(prog.get(pnd.get(i)) instanceof Jump){
	            ((Jump)prog.get(pnd.get(i))).setTarget(ic);
	         }
             if(prog.get(pnd.get(i)) instanceof JumpT){
                ((JumpT)prog.get(pnd.get(i))).setTarget(ic);
             }
             if(prog.get(pnd.get(i)) instanceof Push){
                ((Push)prog.get(pnd.get(i))).setConst(ic);
             }
	      }
          pends.remove(s);
	   }
    }
    
    private int mkTarget(String lb){
        Integer i = m.get(lb);
        if(i != null){
            return i;
        }
        else{
          
          ArrayList<Integer> pnd = pends.get(lb); 
          if(pnd == null ){
             pnd = new ArrayList<Integer>();
             pnd.add(ic);
             pends.put(lb,pnd);
          }else{ pnd.add(ic); }
        }
        return -1;
    }
	
%}

%init{
    hasNext = true;
    m = LabelsMap.mkInstance();
    ic = 0;
    prog = new ArrayList<>();
    pends = new Hashtable<String,ArrayList<Integer>>();
%init}

LineTerminator = \r|\n|\r\n
LineComment    = "--" [^\n\r]*
Ws             = {LineTerminator} | {LineComment} | [ \t\f]

LowerLetter = [a-z]
UpperLetter = [A-Z]

Num    = [:digit:] [:digit:]*
Real   = {Num}"."{Num}
Id     = {LowerLetter} ({LowerLetter} | {UpperLetter} | [:digit:])*
SingleCharacter = [^\r\n\'\\]

%state CHARLITERAL
%state COMMENT 
%state JUMP
%state JUMPT
%state PUSH
%state LABEL
%state ID
%%    

<YYINITIAL> {
        "addi"   { ic++;return new AddI(yyline+1,yycolumn+1);  } 
        "subi"   { ic++;return new SubI(yyline+1,yycolumn+1);  }  
        "multi"  { ic++;return new MultI(yyline+1,yycolumn+1); } 
        "divi"   { ic++;return new DivI(yyline+1,yycolumn+1);  }
        "addf"   { ic++;return new AddF(yyline+1,yycolumn+1);  }
        "subf"   { ic++;return new SubF(yyline+1,yycolumn+1);  }
        "multf"  { ic++;return new MultF(yyline+1,yycolumn+1); }
        "divf"   { ic++;return new DivF(yyline+1,yycolumn+1);  }
        "and"    { ic++;return new And(yyline+1,yycolumn+1);   }
        "or"     { ic++;return new Or(yyline+1,yycolumn+1);    }
        "not"    { ic++;return new Not(yyline+1,yycolumn+1);   }
        "lt"     { ic++;return new Lt(yyline+1,yycolumn+1);    }
        "gt"     { ic++;return new Gt(yyline+1,yycolumn+1);    }
        "eq"     { ic++;return new Eq(yyline+1,yycolumn+1);    } 
        "pop"    { ic++;return new Pop(yyline+1,yycolumn+1);   } 
        "dup"    { ic++;return new Dup(yyline+1,yycolumn+1);   }        
        "load"   { ic++;return new Load(yyline+1,yycolumn+1);  } 
        "store"  { ic++;return new Store(yyline+1,yycolumn+1); }    
        "pc"     { ic++;return new Pc(yyline+1,yycolumn+1);    }
        "jumps"  { ic++;return new JumpS(yyline+1,yycolumn+1); }
        "jumpst" { ic++;return new JumpST(yyline+1,yycolumn+1);}
        "halt"   { ic++;return new Halt(yyline+1,yycolumn+1);}
        "getch"  { ic++;return new Get(yyline+1,yycolumn+1);}
        "putch"  { ic++;return new Put(yyline+1,yycolumn+1);}
        
        "push"   { yybegin(PUSH); }
        "jump"   { yybegin(JUMP); }
        "jumpt"  { yybegin(JUMPT);}
        {Id}     { yybegin(ID); str = yytext();}
        
        
        "{-"     { cCount++; yybegin(COMMENT);    }
       
        {Ws}     {/* Ignorar  */ }
 }

<JUMP>{
    {Id}  {int i = mkTarget(yytext()); yybegin(YYINITIAL) ; ic++;return new Jump(yyline+1,yycolumn+1,i);}
    {Ws}  { }
    .     { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + "Expecting a label, but \""+yytext()+"\" found." ); }
}

<JUMPT>{
    {Id}  {int i = mkTarget(yytext()); yybegin(YYINITIAL) ;ic++;return new JumpT(yyline+1,yycolumn+1,i);}
    {Ws}  { }
    .     { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + "Expecting a label, but \""+yytext()+"\" found." ); }
}

<ID>{
   ":"    {yybegin(YYINITIAL); declareLabel(str); }
   {Ws}   { }
}

<PUSH>{
    {Real}  {yybegin(YYINITIAL); ic++;return new Push(yyline+1,yycolumn+1, new Float(yytext()) );          }
    {Num}   {yybegin(YYINITIAL); ic++;return new Push(yyline+1,yycolumn+1, new Integer(yytext()));         }
    "true"  { yybegin(YYINITIAL); ic++;return new Push(yyline+1,yycolumn+1,true); }
    "false" { yybegin(YYINITIAL); ic++;return new Push(yyline+1,yycolumn+1,false);  }
    \'      { yybegin(CHARLITERAL); }
    {Id}    { yybegin(YYINITIAL); str = yytext();int i = mkTarget(yytext());ic++; return new Push(yyline+1,yycolumn+1,i); }
    {Ws}    { }
    .       {throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + "Expecting a real or float, but \""+yytext()+"\" found." ); }
}


<CHARLITERAL>{
  {SingleCharacter}\' { yybegin(YYINITIAL); return new Push(yyline+1,yycolumn+1, (int)yytext().charAt(0)); }
  "\\\\"\'   {yybegin(YYINITIAL);  ic++; return new Push(yyline+1,yycolumn+1,(int)'\\');}
  "\\n"\'     {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\n');}
  "\\t"\'     {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\t');}
  "\\f"\'     {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\f');}
  "\\r"\'     {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\r');}
  "\\b"\'     {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\b');}
  "\\\""\'    {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\"');}
  "\\'"\'     {yybegin(YYINITIAL); ic++; return new Push(yyline+1,yycolumn+1,(int)'\'');}
  \\[0-2]?[:digit:]?[:digit:]?\'  {yybegin(YYINITIAL); 
                                   int c = Integer.parseInt(yytext().substring(1,yylength()-1));
                                   ic++;
                                   return new Push(yyline+1,yycolumn+1,c);}
                                    
   \\.                            { throw new RuntimeException("illegal char escape: \""+yytext()+"\""); }
  {LineTerminator}                { throw new RuntimeException("char definition not ended at the end of the line.");   }
}

<COMMENT>{
    "-}"   { cCount--;  if(cCount == 0){ yybegin(YYINITIAL);}  }
    "{-"   {cCount++; }
    [^"{-""-}"]  { /* descartar ! */}
}
 
[^]            { throw new RuntimeException("unexpected input char at line " + (yyline+1) +  " '" + yytext() + "'"); }
