package stackMachine;

import java.util.Hashtable;
import java.util.Set;

public class LabelsMap {
     
   private Hashtable<String,Integer> lb;
   
   private static LabelsMap instance = null;
   
   private LabelsMap () {
      lb = new Hashtable<String,Integer>();
   }

   public static LabelsMap mkInstance(){
      if(instance == null){
         instance = new LabelsMap();
      }
      return instance;
   }
      
   public void put(String s,Integer i){ lb.put(s,i);}
   public Integer get(String s){ return lb.get(s); }
   public void clear(){ lb.clear();}
   
   public String toString(){
        StringBuilder sb = new StringBuilder();
        Set<String> keys = lb.keySet();
        for(String key: keys) {
            sb.append(key+"->"+lb.get(key)+"\n");
        }
        return sb.toString();
   }
}
