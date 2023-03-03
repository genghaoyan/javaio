
public class CoinTossSimulatorTester {
   public static void main(String[] args) {

      CoinTossSimulator Test = new CoinTossSimulator();


      int[] Testline1 = {0, 1, 10, 100};
      int[] Testline2 = {0, 1000};

      for (int i : Testline1) {

         int Result[] = Test.run(i);

         if (i == 0) {
            System.out.println("After constructor:");
            System.out.println("Number of trials [exp:0]: " + Result[3]);
         } else if (i == 1) {
            System.out.println("After run(1):");
            System.out.println("Number of trials [exp:1]: " + Result[3]);
         } else if (i == 10) {
            System.out.println("After run(10):");
            System.out.println("Number of trials [exp:10]: " + Result[3]);
         } else {
            System.out.println("After run(100):");
            System.out.println("Number of trials [exp:100]: " + Result[3]);
         }

         System.out.println("Two-head tosses: " + Result[0]);
         System.out.println("Two-tail tosses: " + Result[2]);
         System.out.println("One-head one-tail tosses: " + Result[1]);
         if (Result[0] + Result[1] + Result[2] == Result[3])
            System.out.print("Tosses add up correctly? Ture");
         else
            System.out.print("Tosses add up correctly? False");
         System.out.println("\n " );

      }

      System.out.println("After reset:");
      Test.reset();
      for (int i : Testline2) {

         int Result[] = Test.run(i);

         if (i == 0) {
            System.out.println("Number of trials [exp:0]: " + Result[3]);
         } else {
            System.out.println("After run(1000):");
            System.out.println("Number of trials [exp:100]: " + Result[3]);
         }
         System.out.println("Two-head tosses: " + Result[0]);
         System.out.println("Two-tail tosses: " + Result[2]);
         System.out.println("One-head one-tail tosses: " + Result[1]);
         if (Result[0] + Result[1] + Result[2] == Result[3])
            System.out.print("Tosses add up correctly? Ture");
         else
            System.out.print("Tosses add up correctly? False");
         System.out.println("\n" );

      }

   }
}




