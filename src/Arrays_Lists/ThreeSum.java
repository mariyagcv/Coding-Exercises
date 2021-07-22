package Arrays_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        int rightPtr = nums.length-1;
        int currRes = 0 ;

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // we first FIX the first element (to be each one in the list) and then we use two pointers
        // to find the two other elements
        for(int i=0; i<nums.length-2; i++) { //-2 since leftPtr will be at penultimate and rightpointer at last element, so no point checking more
            int leftPtr = i+1;

            while(leftPtr<rightPtr) {
                currRes = nums[leftPtr] + nums[rightPtr] + nums[i];

                if(currRes==0) {
                    ArrayList<Integer> currSolution = new ArrayList<>();
                    currSolution.add(nums[leftPtr]);
                    currSolution.add(nums[i]);
                    currSolution.add(nums[rightPtr]);

                    res.add(currSolution);
                    // don't forget to move both!
                    leftPtr++;
                    rightPtr--;
                }

                else if(currRes<0) {
                    leftPtr++;
                }
                else {
                    rightPtr--;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        /*
        Possible test cases:
        -1,2,2,-1 -- see if it returns two of the same pairs
        empty string
         */
    }
}
