import java.math.BigInteger;

/*
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

    Find the sum of all the primes below two million = 142913828922 answer.

    Prime numbers are numbers that have only 2 divisors, itself and 1.
 */
public class Problem_10 {

    public static void main(String[] args) {

        BigInteger sumPrimes = new  BigInteger("5"); // included first two primes 2, 3 to start
        BigInteger loopLimit = new BigInteger("2000000");
        for (BigInteger dividend = new BigInteger("5"); dividend.compareTo(loopLimit) <= 0 ; dividend = dividend.add(BigInteger.TWO)){
            boolean isPrime = true;
            for (BigInteger divisor = BigInteger.valueOf(3); divisor.compareTo(dividend.sqrt()) <= 0; divisor = divisor.add(BigInteger.TWO)){
                BigInteger[] answer = dividend.divideAndRemainder(divisor);
                while (answer[1] == BigInteger.ZERO){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                sumPrimes = sumPrimes.add(dividend);
            }
        }
        System.out.println("sumPrimes = " + sumPrimes);
    }
}
