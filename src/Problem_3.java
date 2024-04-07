/*
    Project Euler.net Problem 3
    The prime factors of 13195 are 5,7,13,and 29
    What is the largest prime factor of the number 600851475143?
    Answer is 6857, (71,839, 1471, 6857 are the prime factors)

    Used data type BigInteger, but could have used data type long
    Note: when using long, the value has to be declared with an "L"
    at the end, i.e. long nLong = 600851475143L;
*/

import java.math.BigInteger;

public class Problem_3 {
    public static void main(String[] args) {
        // Methods to print prime numbers or prime factors using different data type
        primeNumbers();
   //     primeFactors();
   //     primeFactorsLong();
        primeFactorsBigInteger();


    }
    public static void primeNumbers(){
        final int NUMBER_OF_PRIMES = 50;
        final int NUMBER_OF_PRIMES_PER_LINE = 10;
        int count = 0;
        int number = 2; // A number to be tested for primeness

        System.out.println("The first 50 prime numbers are: \n");
        // This loop is incrementing variable by 1 each iteration
        // and printing number if it is a prime up to 50 primes (NUMBER_OF_PRIMES)
        while (count < NUMBER_OF_PRIMES) {
            boolean isPrime = true; // Is the current number prime?
            // Test for prime
            int squareRoot = (int) (Math.sqrt(number));
            for (int divisor = 2; divisor <= squareRoot; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false; // set isPrime to false
                    break;  //Exit the for loop
                }
            }
            // Check if the next number is prime
            if (isPrime){
                count++;
                if (count % NUMBER_OF_PRIMES_PER_LINE == 0){
                    System.out.println(number);
                }
                else
                    System.out.print(number + " ");
            }
            number++;
        }
    }
  /*  1. While n is divisible by 2, print 2 and divide n by 2.
      2. After step 1, n must be odd. Now start a loop from i = 3 to square root of n.
         While i divides n, print i and divide n by i, increment i by 2 and continue.
      3. If n is a prime number and is greater than 2, then n will not become 1 by above two steps.
         So print n if it is greater than 2. */
    // Function to print all prime factors of a given number n
    public static void primeFactors(){
        int n = 13195;
        System.out.println("The prime factors of " + n + " using int data type: \n");
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // while i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2) {
            System.out.print(n);
        }
    }

    public static void primeFactorsLong(){
        long nLong = 600851475143L;
        System.out.println("The prime factors of " + nLong + " using long data type: \n");
        while (nLong % 2 == 0) {
            System.out.print(2 + " ");
            nLong /= 2;
        }
        for (int i = 3; i <= Math.sqrt(nLong); i += 2) {
            // while i evenly divides n, print i and divide n
            while (nLong % i == 0) {
                System.out.print(i + " ");
                nLong /= i;
            }
        }
        if (nLong > 2) {
            System.out.print(nLong);
        }
    }
    public static void primeFactorsBigInteger(){
        BigInteger dividend = new BigInteger("600851475143");
        System.out.println("The prime factors of " + dividend + " using BigInteger data type: \n");
        for (BigInteger divisor = BigInteger.valueOf(3); divisor.compareTo(dividend.sqrt()) <= 0; divisor = divisor.add(BigInteger.TWO)){
             BigInteger[] answers = dividend.divideAndRemainder(divisor);
           while (answers[1] == BigInteger.ZERO){
                System.out.println(divisor);
                dividend = answers[0];
                break;
            }
        }
        if (dividend.compareTo(BigInteger.TWO) > 0){
            System.out.println(dividend);
        }
    }
}
