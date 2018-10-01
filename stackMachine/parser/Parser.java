package stackMachine.parser;

import stackMachine.instr.Instr;
import java.io.FileInputStream;
import java.io.IOException;

public class Parser{  

      public Instr[] parseFile(String p){ 
           try{
              StkmScanner sc = new StkmScanner(new FileInputStream(p) );
              return sc.readPog();
           }catch(IOException e){
              e.printStackTrace();
              return null;
           }
      }
}
