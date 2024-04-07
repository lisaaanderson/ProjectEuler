import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing
over five-thousand first names, begin by sorting it into alphabetical order.
Then working out the alphabetical value for each name, multiply this value by its alphabetical
position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth
3+15_12+9+14=53, is the 938th name in the list. So, COLIN would obtain a score of
938 X 53 = 49714.

What is the total of all the name scores in the file? 871198282

Was getting incorrect results using the line.replace for the comma.  The below now works correctly.
 */
public class Problem_22 {
    // Create an array for the alphabet
    static String[] abc = {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public static void main(String[] args) {
        long totalSum = 0;
        //Location of text file containing names
        String filePath = "C:/Users/ander/Documents/Project Euler/0022_names.txt";
        File file = new File(filePath);
        ArrayList<String> names = new ArrayList<>();
        try {

            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
               // line = line.replace(",", "");
                line = line.replaceAll("\"", "");
                String[] lineNames = line.split(",");
                ArrayList<String> strList = new ArrayList<String>(
                        Arrays.asList(lineNames));
                for (String s : strList)
                    names.add(s);
            }
            scanner.close();
        }
        // Catch any errors thrown with file scan
        catch (Exception e){
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }


        Collections.sort(names);
        for (int i = 0; i < names.size(); i++){
            long intSumName = 0;
            intSumName = (getNameSum(names.get(i)) * (i+1));
            totalSum += intSumName;
        }
        System.out.println("Total Sum = " + totalSum);
    }
    public static int getNameSum(String strName){
        int nameSize = 0;
        for (int i = 0; i < strName.length(); i++){
            nameSize += getIndex(Character.toString(strName.charAt(i)));
        }
        return nameSize;
    }

    public static int getIndex(String a){
        int index = 0;
        index = Arrays.asList(abc).indexOf(a);
        return index;
    }
}
