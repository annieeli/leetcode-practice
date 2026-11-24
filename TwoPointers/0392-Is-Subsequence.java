/*
- Problem: Is Subsequence
 *
- Given two strings s and t, return true if s is a subsequence of t, or false 
- otherwise.
 *
- A subsequence of a string is a new string that is formed from the original 
- string by deleting some (can be none) of the characters without disturbing 
- the relative positions of the remaining characters. (i.e., "ace" is a 
- subsequence of "abcde" while "aec" is not).
 *
- Example 1:
- Input: s = "abc", t = "ahbgdc"
- Output: true
 *
- Example 2:
- Input: s = "axc", t = "ahbgdc"
- Output: false
*/

class Main {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int read_s = 0;
        for (int read_t = 0; read_t < t.length(); read_t++) {
            if (read_s >= s.length()) {
                return true;
            }

            if (s.charAt(read_s) == t.charAt(read_t)) {
                read_s++;
            }
        }

        return read_s == s.length();
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: s = "", t = "ahbgdc"; s = "abc", t = ""; s = "aaaaaa", t = "bbaaaa"
