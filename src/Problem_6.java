/*
    The sum of the squares of the first ten natural numbers is,
        1-sq + 2-sq + ...+10-sq = 385
    The square of the sum of the first ten natural numbers is,
        (1 + 2 + ... + 10)-sq = 55-sq = 3025
    Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
    3025 - 385 = 2640.
    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
    answer = 25164150;
    limit = 100
    sum = limit(limit + 1)/2
    sum sq = (2limit + 1)(limit + 1)limit/6
    print sum2 − sum sq
 */
public class Problem_6 {

    public static void main(String[] args) {

        // easier match solution
        int limit = 100;
        int sum = limit * (limit + 1)/2;
        int sq = (2*limit + 1)*(limit + 1) * limit/6;
        System.out.println("Math answer = " + (sum * sum - sq));

        // brute force solution
        int answer = 0;
        int sqSum = 0;
        int sumSq = 0;
        int temp = 0;
        for (int i = 1; i <= 100; i++){
            sqSum = sqSum + (i * i);
            temp = temp + i;
        }
        sumSq = temp * temp;
        answer = sumSq - sqSum;
        System.out.println("Answer is " + answer);
    }
}
