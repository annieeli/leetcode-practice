/*
 * Problem: Merge Strings Alternatively
 *
 * Given two strings word1 and word2, merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, 
 * append the additional letters onto the end of the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int pos1 = 0;
        int pos2 = 0;
        while(word1.length() > pos1 || word2.length() > pos2){
            if(word1.length() > pos1){
                sb.append(word1.charAt(pos1));
                pos1++;
            }

            if(word2.length() > pos2){
                sb.append(word2.charAt(pos2));
                pos2++;
            }
        }

        return sb.toString();
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: ("abcd", "pq"), ("", "pqrs"), ("abcd", "")