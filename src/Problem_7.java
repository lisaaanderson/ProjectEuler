import java.math.BigInteger;

/*
    By listing the first six prime numbers: 2,3,5,7,11, and 13, we can see that the
    6th prime is 13.

    What is the 10001st prime number?
 */
public class Problem_7 {
    public static void main(String[] args) {
        /* number is the variable that is being incremented and determining if it is prime
             Note: number starts at 2 because 1 IS NOT a prime # */
        BigInteger number = new BigInteger("2");
        // variable containing the last Prime identified in the process.
        BigInteger lastPrime = new BigInteger("0");
        // variable that is holding the number of primes to discover
        BigInteger countPrime = new BigInteger("10001");
        // variable holding the number of primes that are discovered
        BigInteger numPrimes = new BigInteger("0");

        // loop through the values, starting with  0 until the countPrime is reached
        while (numPrimes.compareTo(countPrime) < 0){
            boolean isPrime = true;
            BigInteger sqrt = number.sqrt();
    //        System.out.println("while: numPrimes = " + numPrimes + " Prime number = " + number + " number = " + number + " SqRt = " + sqrt);
            for (BigInteger divisor = BigInteger.valueOf(2); divisor.compareTo(sqrt) <= 0; divisor = divisor.add((BigInteger.ONE))){
                BigInteger[] answers = number.divideAndRemainder(divisor);
                if (answers[1].equals(BigInteger.ZERO)){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                lastPrime = number;
                numPrimes = numPrimes.add(BigInteger.ONE);
            }
            number = number.add(BigInteger.ONE);
        }
        System.out.println("end: The " + countPrime + "th Prime = " + lastPrime);
        System.out.println("end: countPrime compared to numPrimes = " + numPrimes.compareTo(countPrime) + " countPrime = " + countPrime + " numPrimes = " + numPrimes);
    }
}
