/*
The following iterative sequence is defined for the set of positive integers:
    n -> n/2 (n is even)
    n - > 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
    13 -> 40 -> 20 -> 10 -> 5 _. 16 -> 8 -> 4 -> 2 -> 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains
10 terms. Although it has not been proved yet (Collatz Problem),
it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?
    answer is HighCountNum = 837799 HighCount = 525

NOTE: Once the chain starts the terms are allowed to go above one million.
*/
public class Problem_14 {

    public static void main(String[] args) {
        long count = 0;
        long highCount = 0;
        long highCountNum = 0;
        for (long i = 1000000; i > Math.sqrt(1000000); i--){
            long n = i;
            count = 1;
            while (n != 1){
                if (n%2==0){
                    n = n/2;
                }
                else {
                    n = 3*n+1;
                }
                count++;
            }
            if (highCount < count){
                highCount = count;
                highCountNum = i;
            }
        }
        System.out.println("HighCountNum = " + highCountNum + " HighCount = " + highCount);
    }
}
