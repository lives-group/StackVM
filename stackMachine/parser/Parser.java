package stackMachine.parser;

import stackMachine.instr.Instr;
import java.io.FileInputStream;
import java.io.IOException;

public class Parser{  

      public Instr[] parseFile(String p){ 
           StkmScanner sc = null;
           try{
              sc = new StkmScanner(new FileInputStream(p) );
              return sc.readPog();
           }catch(IOException e){
              System.out.println("IO Excetipon. Raised excetipon: " );
              e.printStackTrace();
              return null;
           }catch(Exception e){
              int l = sc!=null ? sc.getL() : 0;
              int c = sc!=null ? sc.getC() : 0;
              System.out.println("Unexpected excetipon at line " + l + ", " + c + ". Raised excetipon: ");
              e.printStackTrace();
              return null;
           }
      }
}
