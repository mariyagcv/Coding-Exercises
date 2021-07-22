package Arrays_Lists;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        /*
        Solution: iterative binary search
        Complexity: Time - O(logn), Space - O(1). The recursive binary search takes Space - O(logn) because it keeps values
        on the call stack, while the iterative one is better in space

        Good explanation: https://www.youtube.com/watch?v=L7gNay1c4ak
        */

        // recursive binary search
        int right = nums.length-1;
        int left = 0;

        /*
         Mid can be written as mid = left+(right-left)/2 too, since the classical (left+right)/2 fails if the sum of low and high is greater than the maximum positive int value(2^31 – 1 ).
         https://www.geeksforgeeks.org/binary-search/
        */

        while(left<right) {
            int mid = (left + right + 1)/2;

            if(nums[mid-1] > nums[mid]) {
                right = mid-1;
            }
            else {
                left=mid;
            }
        }

        return left; // doesn't matter if we return left or right
    }

    public static void main(String[] args) {
        findPeakElement(new int[]{1,2,1,3,5,6,4}); //expected 5; e.g2: [1,2,3,1], expected 2
    }
}
