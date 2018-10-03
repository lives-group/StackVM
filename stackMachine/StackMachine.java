package stackMachine; 

import stackMachine.instr.Instr;
import stackMachine.synPrettyPrint.*; 
import stackMachine.parser.Parser; 


public class StackMachine {
   
   private Instr[] program;
   private MachState st;
   private ConcreteSyn syn;
   
   public StackMachine(){
       st = new MachState();
       syn = new DefaultSyntax();
   }
   
   public StackMachine(ConcreteSyn csyn){
       st = new MachState();
       syn = csyn;
   }
   
   public void runProgram(){
       try{ 
          if(program == null){ 
              System.out.println("No program loaded. Nothing to execute !");
              return;
          }
          while((st.readPc() >= 0  && st.readPc() < program.length) && !st.isHalted()){
              program[st.readPc()].execute(st);    
          }
          if (st.readPc() < 0  || st.readPc() >= program.length){
              System.out.println("[ ALERT ]: PC was placed outside the program's memory range.\n Program ended. \n");
              
          }
          if(st.isDebugable()){ System.out.println("\n"+st.state2Str());}
       }catch(Exception e){
           System.out.println("[ ERROR ]: Illegal/inconsistent operation executed by instruction at " + 
                               program[st.readPc()].getLine() + ", " + program[st.readPc()].getColumn() + "\n" +
                               program[st.readPc()].pPrint(syn) + "\n Program aborted. \n" + 
                               "Exception raised : " + e.getMessage()  );
           if(st.isDebugable()){ System.out.println("\n"+st.state2Str());}
       }
   }

   
   private String addres2str(int a){
        int nd  =  a==0 ? 1 : (int)(Math.log10(a) + 1);
        int mxd =  (int) (Math.log10(program.length) + 1);
        String s = "";
        for(int k = 0; k< mxd-nd;k++){s+=" ";}
        return s + a; 
   } 
   
   
   public void printProgram(){
      if(program == null){ 
          System.out.println("No program loaded. Nothing to print !");
          return;
      }
      for(int i = 0 ; i < program.length; i++){
         System.out.println(addres2str(i) + " : " + program[i].pPrint(syn));
      }
      //System.out.println("LabelsMap: \n"+ LabelsMap.mkInstance().toString());
   }
   
   public void loadFile(String p){ 
       Parser sc = new Parser();
       program = sc.parseFile(p);
   }
}
