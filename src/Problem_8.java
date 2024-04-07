/*
The four adjacent digits in the 1000-digit number that
have the greatest product are 9 x 9 x 8 x 9 = 5832.

73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450

Find the thirteen adjacent digits in the 1000-digit number
that have the greatest product. What is the value of this product? 23514624000
 */
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Problem_8 {

    public static void main(String[] args) throws Exception {
        // Specify the path to the .txt file
        String filePath = "c:/users/ander/Documents/input.txt";
        // Create a File object
        File file = new File(filePath);
        String[] lines = new String[20];
        int[] listNums = new int[1000];
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                lines[i++] = scanner.nextLine();
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            // Handle file not found exception
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
        System.out.println("This is the lines.length = " + lines.length);
        System.out.println("The length of the first line = " + lines[0].length());
        int count = 0;
        for (int i = 0; i < lines.length; i++){
            // write all the numbers from the lines[] to listNum[]
            for (int j = 0; j < lines[i].length(); j++){
                listNums[count] = Character.getNumericValue(lines[i].charAt(j)) ;
                count++;
            }
        }

        // Now that I have the text numbers in an int[], can determine highest consecutive product
        int increment = 0;
        int countNum = 13;
        // I was getting incorrect results because the int couldn't hold the solution
        // int can only go up to 2,147,483,647 and the answer was 23,514,624,000
        long product = 0;
        long highProd = 0;
        int[] highNumArr = new int[countNum];
        int[] conseNumArr = new int[countNum];
        for (int k = 0; k < listNums.length; k++){
            if (increment < countNum) {
                conseNumArr[k] = listNums[k];
                increment++;
            }
            else {
                product = 1;
                for (int x = 0; x < conseNumArr.length; x++){
                    product = product * conseNumArr[x];
                }
                if (highProd <= product){
                    highProd = product;
                    // populate highNumArr with conseNumArr
                    for (int y = 0; y < conseNumArr.length; y++){
                        highNumArr[y] = conseNumArr[y];
                    }
                }
                // move values to the left by 1 position in conseNumArr
                for (int z = 1; z < conseNumArr.length; z++){
                    conseNumArr[z-1] = conseNumArr[z];
                }
                conseNumArr[conseNumArr.length - 1] = listNums[k++];
                k--;
            }
        }
        System.out.println("Highest Product = " + highProd);
    }

}
