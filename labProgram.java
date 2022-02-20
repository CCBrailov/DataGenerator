import java.util.Scanner; 

public class labProgram {
   public static void main(String[] args) {
      
      Scanner scnr = new Scanner(System.in);
      
      int values[] = new int[scnr.nextInt()];
      
      int i;
      
      for (i = 0; i < values.length; ++i){
          values[i] = scnr.nextInt();
      }

      scnr.close();

      int smallest = values[0];
      int nextSmallest = values[1];

      /*System.out.println("smallest: " + smallest);
      System.out.println("second: " + nextSmallest);*/

      for (i = 0; i < values.length; ++i){
          if (values[i] <= smallest) {smallest = values[i];}
          /*System.out.println("value: " + values[i]);
          System.out.println("smallest: " + smallest);
          System.out.println("second: " + nextSmallest);
          System.out.println();*/
      }

      for (i = 0; i < values.length; ++i) {
          if (values[i] <= nextSmallest && values[i] > smallest){
              nextSmallest = values[i];
          }
      }

        System.out.println(smallest);
        System.out.println(nextSmallest);
    
   }
   
}