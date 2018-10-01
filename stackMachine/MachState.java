package stackMachine;

import java.util.Stack;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MachState {
     
   private Object[] memory;
   private ArrayList<Integer> used;
   private Stack<Object> stk;
   private int pc;
   private boolean debugable;
   private boolean halted;
   private InputStream inp;
   private OutputStream out;

   public MachState(int msize, int pc_start, boolean debug){
      memory = new Object[msize];
      debugable = debug;
      halted = false;
      used = debug ? new ArrayList<Integer>() : null;
      stk = new Stack<Object>();
      pc = pc_start;
      inp = System.in;
      out = System.out;
    
   }

   public MachState(int pc_pos){
      this(4096,pc_pos,true);
   }
   
   public MachState(){
      this(4096,0,true);
   }
   
   
   public Object readMem(int pos){ return memory[pos];}
   public void writeMem(int pos, Object o){ 
        memory[pos] = o;
        if(debugable && !used.contains(pos) ){
           used.add(pos);
        }
   }
   
   public int readPc(){ return pc;}
   public void setPc(int p){ pc = !halted ? p : pc;}
   public void nextPc(){ pc++;}
   public boolean isDebugable(){ return debugable;}
   
   public void push(Object o){ stk.push(o);}
   public Object pop(){ return stk.pop(); }
   public Object top(){ return stk.peek(); }
   
   public void halt(){ halted = true;}
   public boolean isHalted(){return halted;}
   
   public void setInputStream(InputStream is){ inp = is;}
   public void setOutputStream(OutputStream os){ out = os;}
   
   public int getCh(){ 
       try{
          return (int)inp.read();
       }catch(IOException e){
          System.out.println("IOException ocurred: " + e.getMessage());
       }
       return -1;
   }
   
   public void putCh(int i){ 
       try{
         out.write(i);
       }catch(IOException e){
          System.out.println("IOException ocurred: " + e.getMessage());
       }
   }
   
   
   private String addres2str(int a){
        int nd  =  a==0 ? 1 : (int)(Math.log10(a) + 1);
        int mxd =  (int) (Math.log10(memory.length) + 1);
        String s = "";
        for(int k = 0; k< mxd-nd;k++){s+=" ";}
        return s + a; 
   } 
   
   
   public String state2Str(){
        String s = "";
        Integer[] x;
        x = used.toArray(new Integer[0]);
        java.util.Arrays.sort(x);
        if(!stk.empty()){
           s += "------------------------ STACK STATUS ----------------\n";
           s += "top->" + stk.peek() + "\n";
           for(int i = stk.size()-2; i>= 0 ; i--){
              s+= "     " + stk.get(i).toString() + "\n";
           }    
        }
        s += "------------------------ MEMORY STATUS ----------------\n";
        s += x.length + " memory cells used \n";
        for(int i = 0; i < x.length; i++){
            s += addres2str(x[i]) + " : " + memory[i].toString() + "\n";
        }
        return s;
   }
   

}
