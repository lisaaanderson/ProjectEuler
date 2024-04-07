/*
In the 20x20 grid below, four numbers along a diagonal line have been marked in red.
Row 11 value 26, row 12 value 63, row 12 value 78, and row 13 value 14

08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48

The product of these numbers is 26 x 63 x 78 x 14 = 1788696.

What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally)
in the 20 x 20 grid. = 70600674

Horizontally HighProd = 48477312
Vertical HighProduct = 51267216
Left Diagonal HighProduct = 40304286
Right Diagonal HighProduct = 70600674
The Highest Product = 70600674

Saw solutions where used array[][]
for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j]=scan.nextInt();
            }
        }
        long z = 0;
        long z1 = 0;
        long a = 0;
        long a1 = 0;
        long b = 0;
        long b1 = 0;
        long c = 0;
        long c1 = 0;
        long N = 0;

        for (int i = 19; i > 2; i--) {
            for (int j = 0; j < 17; j++) {
                z = m[i][j] * m[i-1][j+1] * m[i-2][j+2] * m[i-3][j+3];
                if (z>z1) {z1=z;}
            }
        }
        for (int i = 0; i < m.length-3; i++) {
            for (int j = 0; j < m[i].length-3; j++) {
                a = m[i][j] * m[i+1][j+1] * m[i+2][j+2] * m[i+3][j+3];
                 if (a>a1) {a1=a;}
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length-3; j++) {
                b = m[i][j] * m[i][j+1] * m[i][j+2] * m[i][j+3];
                 if (b>b1) {b1=b;}
            }
        }

        for (int i = 0; i < m.length-3; i++) {
            for (int j = 0; j < m[i].length; j++) {
                c = m[i][j] * m[i+1][j] * m[i+2][j] * m[i+3][j];
                if (c>c1) {c1=c;}
            }
        }
        if (z1>c1&&z1>b1&&z1>a1) {N=z1;}
        else if (c1>b1&&c1>a1) {N=c1;}
        else if (b1>a1) {N=b1;}
        else {N=a1;}
        System.out.println(N);

    }
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Problem_11 {

    public static void main(String[] args) throws Exception {
        // File containing above 20x20 matrix of numbers
        String filePath = "C:/Users/ander/Documents/girdInput.txt";
        File file = new File(filePath);
        // Text file scanned into String array
        String[] lines = new String[20];
        // int array holding parsed values
        int[] listArr = new int[400];
        // Index incremented for the listArr[]
        int count = 0;
        // Read in text file and store in String lines[]
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()){
                lines[i++] = scanner.nextLine();
            }
            scanner.close();
        }
        // Catch any errors thrown with file scan
        catch (Exception e){
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
        // Split lines[] by " " to get numbers in 20x20 array
        // This reads as, for each lines[] index do...
        for (String str : lines) {
            // Array storing the values that is parsed from lines[].
            // There will be 20 values on each line
            String[] numbersAsString = str.split(" ");
            // int array that will be used to store the parsed numbers
            int[] numbers = new int[numbersAsString.length];
            // Loop through the numbersAsString[] and parse the String to an int
            for (int i = 0; i < numbersAsString.length; i++){
                numbers[i] = Integer.parseInt(numbersAsString[i]);
                // Store the parsed integers in listArr[] since there are 20 lines
                // and each iteration in this for loop only parses 1 line of text
                listArr[count] = numbers[i];
                // Increment the listArr index by 1
                count++;
            }
        }

        int product = 0;
        long highProd = 0;
        int x = 0;
        int sqRoot = (int) Math.sqrt(listArr.length); // size of the 20x20 grid
        int y = sqRoot;
        // process grid horizontally
        for (int i = x; i <= (y - 4); i++){
         //   System.out.println("listArr[i] = " + listArr[i] + " listArr[i+1] = " + listArr[i+1] + " listArr[i+2] = " + listArr[i+2] + " listArr[i+3] = " + listArr[i+3]);
         //   System.out.println("Product = " + product + " and HighProd = " + highProd);
            product = listArr[i] * listArr[i+1] * listArr[i+2] * listArr[i+3];
            if (highProd < product){
                highProd = product;
         //       System.out.println("Product = " + product + " and HighProd = " + highProd);
            }
            if (i == (y-4) && i < (listArr.length - 4)){
                x = x + sqRoot;
                y = y + sqRoot;
                i = x;
          //      System.out.println("Product = " + product + " and HighProd = " + highProd);
            }
        }
        System.out.println("Horizontally HighProd = " + highProd);
        // process grid vertically
        x = 0; // reinitialize existing variable for x (was declared above)
        long vHighProduct = 0;
        for (int i = x; i < (listArr.length - 3*sqRoot); i++){
        //    System.out.println("i+2*sqRoot = " + i+2*sqRoot);
        //    System.out.println("listArr[i] = " + listArr[i] + " listArr[i+sqRoot] = " + listArr[i+sqRoot] + " listArr[i+2(sqRoot)] = " + listArr[i+(2*sqRoot)] + " listArr[i+(3*sqRoot)] = " + listArr[i+(3*sqRoot)]);
            product = listArr[i] * listArr[i+sqRoot] * listArr[i+(2*sqRoot)] * listArr[i+(3*sqRoot)];
            if (vHighProduct < product){
                vHighProduct = product;
            }
        }
        System.out.println("Vertical HighProduct = " + vHighProduct);
        x = 0; // reinitialize existing variable for x (was declared above)
        y = sqRoot; // reinitialize existing variable for y (was declared above)
        long lDHighProduct = 0;
        for (int i = x; i <= (y-4); i++){
      //      System.out.println("listArr[i] = " + listArr[i] + " listArr[i+sqRoot+1] = " + listArr[i+sqRoot+1] + " listArr[i+2(sqRoot)+2] = " + listArr[i+(2*sqRoot+2)] + " listArr[i+(3*sqRoot+3)] = " + listArr[i+(3*sqRoot+3)]);
            product = listArr[i] * listArr[i+sqRoot+1] * listArr[i+2*sqRoot+2] * listArr[i+3*sqRoot+3];
            if (lDHighProduct < product){
                lDHighProduct = product;
            }
            if (i == (y-4) && i < (listArr.length - 3*sqRoot-4)){
                x = x + sqRoot;
                y = y + sqRoot;
                i = x;
            }
        }
        System.out.println("Left Diagonal HighProduct = " + lDHighProduct);
        x = 3; // reinitialize existing variable for x (was declared above)
        y = sqRoot; // reinitialize existing variable for y (was declared above)
        long rDHighProduct = 0;
        for (int i = x; i < y; i++){
            //System.out.println("listArr[i] = " + listArr[i] + " listArr[i+sqRoot-1] = " + listArr[i+sqRoot-1] + " listArr[i+2(sqRoot)-2] = " + listArr[i+(2*sqRoot-2)] + " listArr[i+(3*sqRoot-3)] = " + listArr[i+(3*sqRoot-3)]);
            product = listArr[i] * listArr[i+sqRoot-1] * listArr[i+2*sqRoot-2] * listArr[i+3*sqRoot-3];
            if (rDHighProduct < product){
                rDHighProduct = product;
            }
            if (i == (y-1) && i < (listArr.length - 3*sqRoot-1)){
                x = x + sqRoot;
                y = y + sqRoot;
                i = x;
            }
        }
        System.out.println("Right Diagonal HighProduct = " + rDHighProduct);
        long highestProduct = 0;
        if (highestProduct < highProd) {
            highestProduct = highProd;
        }
        if (highestProduct < vHighProduct){
            highestProduct = vHighProduct;
        }
        if (highestProduct < lDHighProduct){
            highestProduct = lDHighProduct;
        }
        if (highestProduct < rDHighProduct){
            highestProduct = rDHighProduct;
        }
        System.out.println("The Highest Product = " + highestProduct);

    }
}
