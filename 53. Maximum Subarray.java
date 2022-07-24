// Runtime: 2 ms, faster than 71.29% of Java online submissions for Maximum Subarray.
// Memory Usage: 75 MB, less than 29.09% of Java online submissions for Maximum Subarray.

class Solution {
    // Kadane’s algorithm
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
  
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + nums[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            // if we have a negative sum, we replace it with the current positive number.
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
