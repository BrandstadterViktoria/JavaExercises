import java.util.ArrayList;

public class Total {
   private ArrayList<Integer> integers;

   public Total(ArrayList <Integer> integers){
       integers = new ArrayList <>();
       for (int i = 1; i <10 ; i++){
           integers.add(i);
       }
       this.integers=integers;
   }

   public int total (ArrayList <Integer>integers){
       int total = 0;
       for(int i = 1; i < integers.size(); i++){
           total += integers.get(i);
       }
       return total;
    }

}
