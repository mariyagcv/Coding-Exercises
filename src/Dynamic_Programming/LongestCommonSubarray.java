package Dynamic_Programming;
/*
Same question as "longest common substring" but with an int array.
e.g in: [1,2,3,2,1], [3,2,1,4,7]
out: 3 (the array is [3,2,1]

Complexity: O(n^2)

Note: subSTRING != subSEQUENCE, substring means the elements are adjacent
 */
public class LongestCommonSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];



        int maxLength = 0;


        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                // rows and columns are 0 since if we have empty string ' ' and whatever is the other word (e.g ABCD)
                // then the common subsequence is always 0; vice versa for ABCD with ' '

                if(j==0 || i==0)
                    dp[i][j] = 0;

                else if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = 0;

                if(dp[i][j] > maxLength)
                    maxLength = dp[i][j];
            }
        }

        return maxLength; //note here that the answer is not the end of the matrix (as in some DP problems) since the substrings
        // might not be matching at the end (the row might be 0s); instead, we keep track of the max while iterating the table
    }
}
