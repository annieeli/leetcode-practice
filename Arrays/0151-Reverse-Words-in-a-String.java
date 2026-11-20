/*
- Problem: Reverse Words in a String
 *
- Given an input string s, reverse the order of the words.
 *
- A word is defined as a sequence of non-space characters. The words in s will 
- be separated by at least one space.
 *
- Return a string of the words in reverse order concatenated by a single space.
 *
- Note that s may contain leading or trailing spaces or multiple spaces between 
- two words. The returned string should only have a single space separating the 
- words. Do not include any extra spaces.
 *
- Example 1:
- Input: s = "the sky is blue"
- Output: "blue is sky the"
 *
- Example 2:
- Input: s = "  hello world  "
- Output: "world hello"
 *
- Example 3:
- Input: s = "a good   example"
- Output: "example good a"
*/

class Main {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String[] sArray = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = sArray.length-1; i >= 0; i--){
            if(sArray[i] == " "){
                continue;
            }

            sb.append(sArray[i]);

            if(i != 0){
                sb.append(" ");
            }  
        }

        return sb.toString();
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: s = "   a   "; s = "a good   example"; s = "single"