package Arrays_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// asked on interview!
// Good explanation: https://www.youtube.com/watch?v=FdzJmTCVyJU

public class MinMeetingRooms {
    // Complexity: O(nlogn) (from sorting)
    // todo: write the solution with a heap
    public static int minMeetingRoomsHeap(int[][] intervals) {
        return 0;
    }

    public static int minMeetingRooms(int[][] intervals) { //int[][] since list of lists..
        int numbersMeetingBeingHeld = 0;
        int max = 0;

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int ptrStarts, ptrEnds;
        ptrStarts = ptrEnds = 0;

        while(ptrStarts < intervals.length && ptrEnds < intervals.length) {
            if(starts[ptrStarts] < ends[ptrEnds]) {
                numbersMeetingBeingHeld++;
                // then we check if within this timeframe another meeting starts, so we move the left ptr
                ptrStarts++;
            }

            else {
                numbersMeetingBeingHeld--; //i.e one meeting has just ended
                ptrEnds++;
            }

            if(numbersMeetingBeingHeld > max)
                max = numbersMeetingBeingHeld;

        }

        return max; // i.e there are at most X meetings which are held at the same time
                                        // so that's the number of conference rooms we need
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{2,15},{36,45},{9,29}, {16,23}, {4,9}}; //expected 2
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};   //expected 2
//        int[][] intervals = new int[][]{{1,18},{18,23},{15,29}, {4,15}, {2, 11}, {5,13}}; //expected 4
        System.out.println("Res is: " + minMeetingRooms(intervals));
    }
}
