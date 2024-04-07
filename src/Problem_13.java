import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.SimpleTimeZone;

/*
    Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
    The first 10 characters are: 5537376230
    Total Sum of all line = 553737623039087663730204874683298597177365983189267200
 */
public class Problem_13 {

    public static void main(String[] args) {
        // File containing 50x100 matrix of numbers
        String filePath = "C:/Users/ander/Documents/gridInput2.txt";
        File file = new File(filePath);
        // Text file scanned into String array
        String[] lines = new String[100];
        // BigInteger array to hold converted values
        BigInteger[] numLines = new BigInteger[100];
        BigInteger sumNum = BigInteger.ZERO;

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
        // loop through lines array to convert String to BigInteger values
        for (String str : lines){
            for (int i = 0; i < lines.length; i++){
               numLines[i] = new BigInteger(lines[i]);
               sumNum = sumNum.add(numLines[i]);
            }
        }
        String first10 = new String(sumNum.toString().substring(0,10));
        System.out.println("The first 10 characters are: " + first10);
        System.out.println("Total Sum of all line = " + sumNum);
    }
}
