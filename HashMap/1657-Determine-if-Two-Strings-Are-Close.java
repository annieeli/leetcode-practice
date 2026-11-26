/*
- Problem: Determine if Two Strings Are Close
 *
- Two strings are considered close if you can attain one from the other using 
- the following operations:
- - Operation 1: Swap any two existing characters.
- - Operation 2: Transform every occurrence of one existing character into 
-   another existing character, and do the same with the other character.
 *
- You can use the operations on either string as many times as necessary.
 *
- Given two strings, word1 and word2, return true if word1 and word2 are close, 
- and false otherwise.
 *
- Example 1:
- Input: word1 = "abc", word2 = "bca"
- Output: true
 *
- Example 2:
- Input: word1 = "a", word2 = "aa"
- Output: false
 *
- Example 3:
- Input: word1 = "cabbba", word2 = "abbccc"
- Output: true
*/

import java.util.Arrays;

class Main {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0) != (freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: word1 = "uau", word2 = "ssx"; word1 = "abbzccca", word2 = "babzzczc"; word1 = "a", word2 = "b"