/*
Let d(n) be defined as the sum of proper divisors of n (numbers less
than n which divide evenly into n). If d(a) = b and d(b) = a, where
a != b, then a and b are an amicable pair and each of a and b
are called amicable numbers.

For example, the proper divisors of 220 are 1,2,4,5,10,11,20,22,44,55 and 110;
therefore d(220) = 284. The proper divisors of 284 are 1,2,4,71 and 142; so
d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
i = 220 sumDivisor(i) = 284
i = 284 sumDivisor(i) = 220
i = 1184 sumDivisor(i) = 1210
i = 1210 sumDivisor(i) = 1184
i = 2620 sumDivisor(i) = 2924
i = 2924 sumDivisor(i) = 2620
i = 5020 sumDivisor(i) = 5564
i = 5564 sumDivisor(i) = 5020
i = 6232 sumDivisor(i) = 6368
i = 6368 sumDivisor(i) = 6232
Total Sum of amicable divisors = 31626

 */
public class Problem_21 {

    public static void main(String[] args) {
        int num = 0;
        int totalSum = 0;
        for (int i = 1; i< 10000; i++){
            num = sumDivisors(i);
            if (sumDivisors(num) == i && i != num){
                System.out.println("i = " + i + " sumDivisor(i) = " + sumDivisors(i));
                totalSum += i;
            }
        }
        System.out.println("Total Sum of amicable divisors = " + totalSum);
    }

    public static int sumDivisors(int number){
        int sum = 0;
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
