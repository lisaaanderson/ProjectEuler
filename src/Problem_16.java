import java.math.BigInteger;

/*
 2 to the 15th = 32768 and the sum of its digits is 3+2+7+6+8=26.

What is the sum of the digits of the number 2 to 1000? 1366
 */
public class Problem_16 {

    public static void main(String[] args) {
        BigInteger number = new BigInteger("2");
        BigInteger result = number.pow(1000);
        System.out.println("result = " + result);
        String strNum = result.toString();
        System.out.println("strNum = " + strNum);
        System.out.println("strNum.length = " + strNum.length());
        long sum = 0;

        for (int i = 0; i < strNum.length(); i++){
            sum = sum + Long.parseLong(Character.toString(strNum.charAt(i)));
         //   System.out.println("i = " + i + " character = " + Long.parseLong(Character.toString(strNum.charAt(i))) + " sum = " + sum);
        }
        System.out.println("Sum = " + sum);
    }
}
