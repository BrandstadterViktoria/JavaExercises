import java.util.ArrayList;

public class Total {
   private ArrayList<Integer> integers;

   public Total(){
       integers = new ArrayList <>();
   }

   public int total (ArrayList <Integer>integers){
       int total = 0;
       for(int i = 1; i < integers.size(); i++){
           total += integers.get(i);
       }
       return total;
    }

}
