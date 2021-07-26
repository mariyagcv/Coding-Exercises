package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NQueensProblem {
    /*
    A Backtracking problem. Print out all positions in which 4 queens can be at without attacking each other

    Solution: A Queen can't be on the row, column, or diagonal with a queen. We can approach the problem by
    working at each row level. So, we find a column for the first queen, then we go to the next row (because we know
    the next queen can't be on the same row) and we find a column for the next queen, etc etc).

    So we can return only column numbers of each queen.

    Complexity: O(N!) because we fix a queen at each level so we have 4*3*2*1 options
     */

    public static boolean isValidPosition(ArrayList<Integer> currentSolution) {
        int currentRowId = currentSolution.size()-1; // getting the last
        for(int i=0; i<currentRowId; i++) { //iterate over the column positions that we've found and check if the newly added queen is in the way
            int diff = Math.abs(currentSolution.get(currentRowId) - currentSolution.get(i));
            if (diff==0 || diff == currentRowId - i) { //diff==0 checks for not being in the same column, the other - for diagonals
                return false;
            }
        }
        return true;
    }

    public static void recurseQueens(int chessBoardSize, int rowLevel, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentSolution) {
        // base case: we've exhausted all levels (found columns for queens at all rows)
        if (rowLevel == chessBoardSize) {
            result.add(new ArrayList<>(currentSolution));
            return;
        }

        for(int col=0; col<chessBoardSize; col++) {
            currentSolution.add(col);
            if(isValidPosition(currentSolution)) {
                recurseQueens(chessBoardSize, rowLevel+1, result, currentSolution);
            }
            // then we remove it so that when we go up by a level (during backtracking)
            currentSolution.remove(currentSolution.size()-1);
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueens() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentSolution = new ArrayList<>();
        recurseQueens(4, 0, result, currentSolution);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(nQueens());
    }
}
