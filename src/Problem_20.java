import java.math.BigInteger;

/*
n! means n x (n - 1) x ...x 3 x 2 x 1

For example, 10! = 10 x 9 x .... x 3 x 2 x 1 = 3628800,
and the sum of the digits in the number 10! is 3+6+2+8+8+0+0= 27.

Find the sum of the digits in the number 100! = 648
 */
public class Problem_20 {

    public static void main(String[] args) {

        BigInteger prod = new BigInteger("1");
        String strProd = "";
        int sum = 0;

        for (int i = 100; i > 0; i--){
           prod = prod.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Product = " + prod);
        strProd = String.valueOf(prod);

        for (int i = 0; i < strProd.length(); i++){
            sum = sum + Integer.parseInt(Character.toString(strProd.charAt(i)));
        }
        System.out.println("strProd.length = " + strProd.length());
        System.out.println("Sum of digits = " + sum);

    }


}
