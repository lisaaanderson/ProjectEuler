
/* 2520 is the smallest number that can be divided by each of the numbers from
   1 to 10 without any remainder.
   What is the smallest positive number that is evenly divisible by all of the numbers from
   1 to 20? 232792560
 */

public class Problem_5 {

    public static void main(String[] args) {
        int smallest = 0;
        boolean divisable = true;
        for (int i = 10; i > 0; i += 2){
            divisable = true;
            for (int j = 2; j <= 20; j++){
             //   System.out.println("divisable = " + divisable);
             //   System.out.println("i = " + i + " j = " + j);
                while (divisable){
                    if (i % j == 0){
                        divisable = true;
                    }
                    else {
                        divisable = false;
                    }
                    break;
                }
            }
            if (divisable){
             //   System.out.println("divisable = " + divisable);
                smallest = i;
                break;
            }
        }
        System.out.println("Smallest value = " + smallest);
    }
}
