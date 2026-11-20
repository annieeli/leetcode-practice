/*
- Problem: Reverse Vowels of a String
 *
- Given a string s, reverse only all the vowels in the string and return it.
 *
- The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower 
- and upper cases, more than once.
 *
- Example 1:
- Input: s = "IceCreAm"
- Output: "AceCreIm"
 *
- Example 2:
- Input: s = "leetcode"
- Output: "leotcede"
*/

class Main {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        String vowels = "aeiouAEIOU";
        char[] charArray = s.toCharArray();
        while(left < right){
            while(vowels.indexOf(charArray[left]) == -1 && left < right){
                left++;
            }
            while(vowels.indexOf(charArray[right]) == -1 && left < right){
                right--;
            }

            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: s = "aA"; s = "bcdfg"; s = "aeiou"