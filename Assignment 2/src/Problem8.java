import java.util.*;

public class Problem8{

   public static void main(String [] argc) {
         List <Integer> number=new ArrayList <Integer>();

         number.add(11);
         number.add(45);
         number.add(12);
         number.add(32);
         number.add(36);

         removeEven(number);
         for(int j: number) {
            System.out.print(number.get(j) + " ");
         }
   }

   public static void removeEven(List<Integer> list){
      for (int i : list){
         if (i % 2 == 0) list.remove(i);
      }
   }
}