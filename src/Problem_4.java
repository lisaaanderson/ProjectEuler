/*
    A palindromic number reads the same both ways. The largest palindrome made from the product of two
    2-digit numbers is 9009 = 91 X 99.

    Find the largest palindrome made from the product of two 3-digit numbers.
    Largest Palindrome = 906609
 */

public class Problem_4 {

    public static void main(String[] args) {
        stringPalindrome();
        intPalindrome();
    }

    // This function is not returning anything, so is static void.
    public static void intPalindrome(){
        // define the parameter to hold the largest palindrome number
        int largestPalindrome = 0;
        // problem is looking at 3-digit values, highest it can be is 999
        int a = 999;
        // loop through while a is >= 100, which is the lowest value a 3-digit value can be.
        while ( a >= 100){
            // second value to determine product for, again max value is 999
            int b = 999;
            // loop through while b is >= a
            while (b >= a){
                // if the product is <= the largest palindrome, then break out of the loop.
                if (a * b <= largestPalindrome){
                    break;
                }
                // else if the reversed product = product, then set the largestPalindrome = to the product
                else if (reverse(a * b) == a * b){
                    largestPalindrome = a * b;
                //    System.out.println("Value of a = " + a + " Value of b = " + b);
                }
                // decrement b by 1
                b = b-1;
            }
            // decrement a by 1 until a is less than 100
            a = a-1;
        }
        System.out.println("Largest intPalindrome = " + largestPalindrome);
   }

    /* reverses the number passed in by using the remainder to build the reverse value
        number passed in                        reversed number
          9009 = number to reverse              9 = 0 * 10 + 9009 % 10 (remainder = 9)
          900 = 9009/10 dropping remainder      90 = 9 * 10 + 900 % 10 (remainder = 0)
          90 = 900/10                           900 = 90 * 10 + 90 % 10 (remainder = 0)
          9 = 90/10                             9009 = 900 * 10 + 9 % 10 (remainder = 9)
     */
    public static int reverse(int n){
        // initialize the reversed variable that will be returned.
        int reversed = 0;
        // set the temp variable = the value passed into the function.
        int temp = n;
        // loop through will temp is not equal to 0.
        while (temp != 0){
            // calculate reversed value, % only uses remainder of calculation
            reversed = 10 * reversed + temp % 10;
            // Divides temp by 10 discarding the remainder
            temp = temp /10;
        }
        // return reversed value
        return reversed;
    }

    // This method uses a String and StringBuffer to reverse the product.
    public static void stringPalindrome(){
        int highPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j > 100; j--) {
                if (String.valueOf(i * j).equals(new StringBuffer(String.valueOf(i * j)).reverse().toString())) {
                    if (i * j >= highPalindrome) {
                        highPalindrome = i * j;
                    }
                }
            }
        }
        System.out.println("Highest stringPalindrome = " + highPalindrome);
    }
}