/*
    A Pythagorean triplet is a set of three natural numbers, a < b < c,
    for which, a-sq + b-sq = c-sq

    For example, 3-sq + 4-sq = 9 + 16 = 25 = 5-sq.

    There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    Find the product abc.
 */
public class Problem_9 {

    public static void main(String[] args) {
        for (int a = 1; a < 350; a++){
            for (int b = (a + 1); b < 400; b++){
                long c = (a * a) + (b * b);
                if (isPerfectSqr(c) > 0) {
       //             System.out.println("The isPerfectSqr(c) return value is " + isPerfectSqr(c));
      //              System.out.println("isPerfectSqr(c) a = " + a + " b = " + b + " c = " + isPerfectSqr(c) + " a+b+c = " + (a+b+isPerfectSqr(c)));
                    if (a + b + isPerfectSqr(c) == 1000){
        //                System.out.println(isPerfectSqr(c));
                        System.out.println("Pythagorean triple - a = " + a + " b = " + b + " c = " + isPerfectSqr(c) );
                        System.out.println("Product = " + (a * b * isPerfectSqr(c)));
                        break;
                    }
                }
            }
        }
    }

    public static long isPerfectSqr(long n){
        if (n < 0){
           return 0;
        }
        double squareRoot = Math.sqrt(n);
        long test = (long) (squareRoot + .5);
        if (test * test == n){
            return test;
        }
        else return 0;
    }
}
