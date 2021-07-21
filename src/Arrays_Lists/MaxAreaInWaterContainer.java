package Arrays_Lists;

public class MaxAreaInWaterContainer {
    //https://leetcode.com/problems/container-with-most-water/
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     */
    public int maxArea(int[] height) {
        int leftPtr, rightPtr;
        leftPtr = 0;
        rightPtr = height.length-1;

        int maxArea = 0;
        int area;

        while(leftPtr<rightPtr) {
            area = Math.min(height[rightPtr], height[leftPtr]) * (rightPtr-leftPtr);
            maxArea = Math.max(maxArea, area);

            if(height[leftPtr] < height[rightPtr]) {
                leftPtr++;
            }
            else {
                rightPtr--;
            }


        }

        return maxArea;
    }
}
