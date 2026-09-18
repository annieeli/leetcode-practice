// Problem: Longest Unique Action Sequence

// You are given a string s representing a sequence of user keyboard actions. 
// You need to find the length of the longest contiguous substring that contains no repeating characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// // Explanation: The longest valid substring is "abc", which has a length of 3.

public class Main {
    public int longestUniqueString(String s){
        int left = 0;
        int right = 0;

        int output = 0;

        boolean[] occurance = new boolean[128];

        while(right < s.length()){
            char c = s.charAt(right);
            while(occurance[c]){
                occurance[s.charAt(left)] = false;
                left++;
            }

            occurance[c] = true;
            output = Math.max(right-left+1, output);
            right++;
        }

        return output;
    }
}
