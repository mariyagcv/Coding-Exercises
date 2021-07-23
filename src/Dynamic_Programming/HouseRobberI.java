package Dynamic_Programming;
/*
https://leetcode.com/problems/house-robber/
 */
public class HouseRobberI {
    public int rob(int[] nums) {
        // edge cases
        if(nums.length==1)
            return nums[0];

        // the dp doesn't have to be a table, it can be an array
        int[] dp = new int[nums.length];

        dp[0] = nums[0]; //initialise first row to 0
        dp[1] = Math.max(nums[0], nums[1]); // if the given array is of length just 2 houses, decide if we're robbing 1st or 2nd

        for(int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
