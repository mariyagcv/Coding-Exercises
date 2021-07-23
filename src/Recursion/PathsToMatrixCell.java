package Recursion;

import java.util.ArrayList;

public class PathsToMatrixCell {
    /*
    The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down
    https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/?ref=leftbar-rightbar
     */
    public static int numberOfPaths(int i, int j) {
        //Complexity:  Exponential - O(2^n)
        // return 1 because if we're on the 1st row or 1st column, we can be
        // in this position only by going one way (either just right, or just down)
        if(i==0 || j==0)
            return 1;
        // otherwise each cell can be reached by the number of ways it can be reached from the left (going right)
        // + the number of ways it can be reached from the top (going down)
        return numberOfPaths(i-1, j) + numberOfPaths(i, j-1);
    }

    public static int numberOfPathsDP(int m, int n) {
        // Complexity: O(m*n)
        // we have overlapping subproblems so we can use dynamic programming to store
        int[][] matrix = new int[m][n];

        //set to 0th row and 0th column to 1 (that's the base case)
        for(int i=0; i < m; i++)
            matrix[i][0] = 1;
        for(int j=0; j < n; j++)
            matrix[0][j] = 1;

        for(int i=1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m-1][n-1];
    }

    // todo: write a print function (has to be exponential, can't be DP)

    public static void main(String[] args) {
        // (3,3) called with DP is same as (2,2) called for the recursion version
        int res = numberOfPathsDP(3,3);
        System.out.println("Result: " + res);
    }
}
