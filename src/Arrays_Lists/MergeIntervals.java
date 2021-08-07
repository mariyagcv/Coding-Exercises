package Arrays_Lists;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        // Complexity: O(nlogn) for sorting; space: O(n)

        Arrays.sort(intervals, (a, b)-> (a[0] - b[0])); //sorts from smallest to largest by FIRST (start) element

        ArrayList<int[]> merged = new ArrayList<>();
        // e.g: (1,4), (2,5), (6,9), (9, 10)
        //out: (1, 5), (6, 10)


        for(int[] interval : intervals) {
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]) //if empty or we CAN'T merge
                merged.add(interval);
            else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }

        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] res = mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for(int[] i : res) {
            System.out.println();
            for(int j : i)
                System.out.print(j);
        }
    }
}
