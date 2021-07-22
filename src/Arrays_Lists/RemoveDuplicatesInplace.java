package Arrays_Lists;

public class RemoveDuplicatesInplace {
    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
     Complexity: O(N) time, O(1) space
     Solution:
     Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j is the fast-runner. As long as nums[i] = nums[j], we increment j to skip the duplicate.
     When we encounter nums[j]!=nums[i], the duplicate run has ended so we must copy its value to nums[i + 1]nums[i+1].
     i is then incremented and we repeat the same process again until j reaches the end of array.


    E.g:
        i       j
    a b c c c c d g -> j will skip all the 3 cs until it reaches d; then on position i+1 (right after the first c),
    the non-duplicate value (d) will be copied, etc etc
     */
    public int removeDuplicates(int[] nums) {
        int i=0;

        if(nums.length==0) return 0;

        for(int j=1; j<nums.length; j++) {
            if(nums[i]!=nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1; // returns the number of elements the non-duplicated array has
    }
}
