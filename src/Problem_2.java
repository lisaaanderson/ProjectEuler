//
// Project Euler.net problem 2
// Fibonacci sequence 1,2,3,5,8,13,21,etc...
// By considering the terms in the Fibonacci sequence whose values do not exceed four million,
// find the sum of the even-valued terms.
//

public class Problem_2 {
    public static void main(String[] args) {
        // declare and initialize variables
        int f0 = 0; // will hold the first value in the sequence
        int f1 = 1; // will hold the second value in the sequence
        int f2 = 0; // will hold the new value for the sequence
        int intSum = 0; // will hold the sum of the even value fibonacci terms

        // do-while loop through sequence until the newSeqValue <= 4,000,000
        do {
            f0 = f1; // move the second value to the first place
            f1 = f2; // move the new value to the second place
            f2 = f0 + f1;
            //System.out.println("new Fibonacci value is = " + f2);
            if (f2 % 2 == 0 && f2 <= 4000000){
              intSum = intSum + f2;
            }
        } while (f2 <= 4000000);
        System.out.println("Last values are: f0 = " + f0 + " f1 = " + f1 + " f2 = " + f2);
        System.out.println("Sum of even values = " + intSum);

    }
}
