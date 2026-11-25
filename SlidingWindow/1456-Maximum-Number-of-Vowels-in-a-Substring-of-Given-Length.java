/*
- Problem: Maximum Number of Vowels in a Substring of Given Length
 *
- Given a string s and an integer k, return the maximum number of vowel letters 
- in any substring of s with length k.
 *
- Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
- Example 1:
- Input: s = "abciiidef", k = 3
- Output: 3
 *
- Example 2:
- Input: s = "aeiou", k = 2
- Output: 2
 *
- Example 3:
- Input: s = "leetcode", k = 3
- Output: 2
*/

class Main {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";

        int max = 0;
        for(int i = 0; i < k; i++){
            if(vowels.indexOf(s.charAt(i)) != -1){
                max++;
            }
        }

        int current = max;
        for(int i = k; i < s.length(); i++){
            if(vowels.indexOf(s.charAt(i)) != -1){
                current++;
            }
            if(vowels.indexOf(s.charAt(i-k)) != -1){
                current--;
            }

            max = Math.max(current, max);
            if(max == k) return k;
        }

        return max;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: s = "rhythms", k = 4; s = "tryhard", k = 4; s = "a", k = 1