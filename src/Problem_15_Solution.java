/*
Answer: 137846528820
 */

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_15_Solution {

    private static BigInteger numberPaths(ArrayList<ArrayList<BigInteger>> grid)
    {
        for(int i = 0; i <= 20; ++i)
        {
            for(int j = 0; j <= 20; ++j)
            {
                int x = j;
                int y = i;
                if(x - 1 < 0 || y - 1 < 0)
                {
                    grid.get(x).set(y, BigInteger.ONE);
                }
                else
                {
                    BigInteger topVal = grid.get(x - 1).get(y);
                    BigInteger leftVal = grid.get(x).get(y - 1);
                    grid.get(x).set(y, topVal.add(leftVal));
                }

            }
        }
        return grid.get(20).get(20); //the solution
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<BigInteger>> grid = new ArrayList<>();
        for(int i = 0; i <= 20; ++i)
        {
            ArrayList<BigInteger> column = new ArrayList<>();
            for(int j = 0; j <= 20; ++j)
            {
                column.add(BigInteger.valueOf(0));
            }
            grid.add(column);
        }
        System.out.println("Answer: " + numberPaths(grid));
    }
}
