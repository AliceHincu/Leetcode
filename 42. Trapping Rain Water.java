        // Approach 2
// Runtime: 3 ms, faster than 25.40% of Java online submissions for Trapping Rain Water.
// Memory Usage: 49.8 MB, less than 9.62% of Java online submissions for Trapping Rain Water.

class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] leftMax = new int[size]; // max height from the left to given point
        int[] rightMax = new int[size]; // max height from the right to given point
        
        leftMax[0] = height[0];
        for(int i=1; i<size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        rightMax[size-1] = height[size-1];
        for(int i=size-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        
        // Minimum between leftMax and rightMax means the dimensions from left to right which can hold the water. You take the minimum, since else it overflows. (ex if in the left is 1 and right is 3, it can hold 1 unit of water)
        int waterContained = 0;
        for(int i=0; i<size; i++) {
            waterContained += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return waterContained;
    }
}
