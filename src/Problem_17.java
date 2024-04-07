import java.sql.Array;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
3+3+5+4+4=19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
how many letters would be used? 21124


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains
23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing
out numbers is in compliance with British usage.
 */
public class Problem_17 {

    public static void main(String[] args) {
        // Create an array to hold base numbers 1-19 and 20-90
        String[] arr = {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                        "eighteen", "nineteen"};
        String[] arr10s = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
                        "ninety"};
        String strH = "hundred";
        String strNum = "";
        for (int i = 1; i <= 1000; i++){
            switch (String.valueOf(i).length()){
                case 1:
                    strNum = strNum + arr[i];
                    break;
                case 2:
                    if (i < 20){
                        strNum = strNum + arr[i];
                        break;
                    }
                    else {
                        strNum = strNum + arr10s[Character.getNumericValue(String.valueOf(i).charAt(0))] +
                                arr[Character.getNumericValue(String.valueOf(i).charAt(1))];
                        break;
                    }
                case 3:
                    strNum = strNum + arr[Character.getNumericValue(String.valueOf(i).charAt(0))] + strH;
                    if (Integer.valueOf(String.valueOf(i).substring(1)) != 0){
                        strNum = strNum + "and";
                    }
                    if (Integer.valueOf(String.valueOf(i).substring(1)) < 20){
                        strNum = strNum + arr[Integer.valueOf(String.valueOf(i).substring(1))];
                        break;
                    }
                    else {
                        strNum = strNum + arr10s[Character.getNumericValue(String.valueOf(i).charAt(1))] +
                            arr[Character.getNumericValue(String.valueOf(i).charAt(2))];
                        break;
                    }
                case 4:
                    strNum = strNum + "onethousand";
                    break;

            }
        }
        System.out.println("Length of strNum.lenght = " + strNum.length());

    }
}
