//
// Project Euler.net problem 1.
// What is the sum of all the numbers from 0 to 1000 that are multiples of 3 or 5?
//    Answer = 233168
//

public class Problem_1 {
    public static void main(String[] args) {
        // initialize the variables used.
        int i = 0;  // iterate through value i from 0 to 1000
        int y = 0;  // add all values that multiples of 3 or 5 to value y
        // iterate through all the values to check if they are multiples and add to sum value of y.
        do {
            if (i % 3 == 0 ) {
                y = y + i;
             //  System.out.println("i is = " + i);
            }
            else if (i % 5 == 0) {
                y = y + i;
             //  System.out.println(("i is = " +i));
            }
            i++;  // increment variable to count up 1 from each pass through the loop
        } while (i < 1000);
        // print out the results added to value y after the iteration is complete.
        System.out.println("Sum of values = " + y);
    }
}