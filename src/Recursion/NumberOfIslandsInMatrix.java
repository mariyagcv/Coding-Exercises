package Recursion;

public class NumberOfIslandsInMatrix {
    /*
    https://leetcode.com/problems/number-of-islands/submissions/
    https://www.youtube.com/watch?v=__98uL6wst8

    Complexity: O(M*N) where M are rows and N columns
     */
    public int numIslands(char[][] grid) {
        int countIslands = 0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        for(int i=0; i<rowLength; i++) {
            for(int j=0; j<columnLength; j++) {
                if(grid[i][j]=='1') {
                    countIslands++;
                    markIslandDfs(i, j, rowLength, columnLength, grid);
                }
            }
        }

        return countIslands;
    }

    public void markIslandDfs(int i, int j, int rowLength, int columnLength, char[][] grid) {
        if(i<0 || i>=rowLength || j<0 || j>=columnLength || grid[i][j]!='1') //if it's 0, we skip because it's water, 2 = visited
            return;
        grid[i][j] = '2'; // 2 = mark as visited

        markIslandDfs(i-1, j, rowLength, columnLength, grid);
        markIslandDfs(i+1, j, rowLength, columnLength, grid);
        markIslandDfs(i, j-1, rowLength, columnLength, grid);
        markIslandDfs(i, j+1, rowLength, columnLength, grid);

    }
}
