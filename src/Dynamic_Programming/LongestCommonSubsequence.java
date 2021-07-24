package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String a, String b) {

        // Write your code here
        int[][] matrix = new int[a.length()+1][b.length()+1]; //todo: +1 ? or not?

        for (int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                if(i==0 || j==0)
                    matrix[i][j] = 0;
                else {
                    if(a.charAt(i-1)==b.charAt(j-1))  //note the -1!
                        matrix[i][j] = 1 + matrix[i-1][j-1];
                    else
                        matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
