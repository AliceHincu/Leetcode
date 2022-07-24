// Runtime: 2 ms, faster than 99.99% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 42.5 MB, less than 89.25% of Java online submissions for Longest Substring Without Repeating Characters.
        
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, longest = 0;
        // frequency vector which saves the next position after the letter so we know where the new left is in case the 
        // letter repeats
        int[] chars = new int[95];
        int offset = 32;
        if(s.length()==1)
            return 1;

        while (right < s.length()) {
            char c = s.charAt(right);
            // in case the letter repeats, modify the left to be after the old appearence of the letter
            // we do the maximum because if a different letter that was deleted appears again, we can put it in the 
            // substring (since it was previously deleted)
            left = Math.max(chars[c - offset], left);
            longest = Math.max(longest, right - left + 1);
            // next position of left if the letter appears again.
            chars[c - offset] = right + 1;
            right++;
        }

        return longest;
    
    }
}
