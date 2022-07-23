// Runtime: 1 ms, faster than 99.71% of Java online submissions for Two Sum.
// Memory Usage: 42.3 MB, less than 93.29% of Java online submissions for Two Sum.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // here we save the number and the index associated with the number; 
        Map<Integer, Integer> mapNums = new HashMap<>();

        int neededValue, currentValue;
        
        // put the pairs in the map and check if the result exists
        for(int i=0; i<nums.length; i++) {
            currentValue = nums[i];
            neededValue = target - currentValue;
            Integer indexNeededValue = mapNums.get(neededValue);
            
            if(indexNeededValue != null) {
                return new int[]{i, indexNeededValue};
            } else {
                mapNums.put(currentValue, i);
            }
        }
        
        return null;
    }
}
