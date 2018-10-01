package stackMachine; 


public class Main {
   
    public static void main(String args[]){
       StackMachine m = new StackMachine();
       if(args.length != 1){ help(); return; }
       m.loadFile(args[0]);
       m.printProgram();
       m.runProgram();
       
    }

    public static void help(){
        System.out.println("Satack Machine 0.1 2018/2");
        System.out.println("Usage:  java -jar stackVM  <InputFile>");
        
    }
}
