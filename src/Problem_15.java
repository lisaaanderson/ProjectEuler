import java.util.ArrayList;
import java.util.List;

/*
Starting in the top left corner of a 2 x 2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20 x 20 grid?  407575348 Wrong
 */
public class Problem_15 {
    // to store the matrix dimensions
    static int M, N;
    static int paths = 0;
    static long posPaths = 0;
    // Function to print the path taken to reach the destination
    static  void printPath(List<Integer> path){

        for (int i : path){
            System.out.print(i + ", ");
        }
        System.out.println();

    }

    // Function to find all possible paths in the matrix from the top-left cell to the
    // bottom-right cell
    static void findPaths(int[][] arr, List<Integer> path, int i, int j){
        // If it's the bottom-right cell, print the path
        if (i == M - 1 && j == N - 1){
            path.add(arr[i][j]);
            posPaths++;
       //     System.out.println(" At the end of the matrix i = " + i + " j = " + j + " path count = " + posPaths);
     //       printPath(path);
            paths++;
            path.remove(path.size() - 1);
            return;
        }

      /*  if (posPaths > arr.length * arr.length){
            return;
        } */

        // Boundary cases: Check if we are out of the matrix
        if (i < 0 || i >= M || j < 0 || j >= N){
            return;
        }

        // Include the current cell in the path
        path.add(arr[i][j]);
        posPaths++;
        //System.out.println("i = " + i + " j = " + j + " new path value = " + arr[i][j] + " path count = " + posPaths);

        // Move right in the matrix
        if (j + 1 < N){
            findPaths(arr, path, i, j + 1);
        }

        // Move down in the matrix
        if (i + 1 < M){
            findPaths(arr, path, i + 1, j);
        }

        // Backtrack: Remove the current cell from the current path
        path.remove(path.size() - 1);
    }

    // Driver code
    public static void main(String[] args) {
        // Input matrix
   /*     int[][] arr = {
                {1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 8, 9, 12},
                {0,0,0,0}
        };*/
        int[][] arr = new int[21][21];
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = count++;
            }
        }

        // To store the path
        List<Integer> path = new ArrayList<>();

        // Starting cell (0, 0)
        int i = 0, j = 0;

        M = arr.length;
        N = arr[0].length;

        // Function call
        findPaths(arr, path, i, j);
        System.out.println("The number of paths = " + paths);
    }
}
