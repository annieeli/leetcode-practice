/*
- Problem: String Compression
 *
- Given an array of characters chars, compress it using the following algorithm:
 *
- Begin with an empty string s. For each group of consecutive repeating 
- characters in chars:
- - If the group's length is 1, append the character to s.
- - Otherwise, append the character followed by the group's length.
 *
- The compressed string s should not be returned separately, but instead, be 
- stored in the input character array chars. Note that group lengths that are 
- 10 or longer will be split into multiple characters in chars.
 *
- After you are done modifying the input array, return the new length of the 
- array. You must write an algorithm that uses only constant extra space.
 *
- Example 1:
- Input: chars = ["a","a","b","b","c","c","c"]
- Output: 6 (["a","2","b","2","c","3"])
 *
- Example 2:
- Input: chars = ["a"]
- Output: 1 (["a"])
 *
- Example 3:
- Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
- Output: 4 (["a","b","1","2"])
*/

class Main {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        
        while(read < chars.length){
            char current = chars[read];

            int counter = 0;
            while(read < chars.length && current == chars[read]){
                counter++;
                read++;
            }

            chars[write] = current;
            write++;

            if(counter > 1){
                for(char digit : String.valueOf(counter).toCharArray()){
                    chars[write] = digit;
                    write++;
                }
            }
        }

        return write;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: chars = ['a','b','c']; chars = ['a','a','a','b','b','a','a']; 
// chars = ['a','a','a','a','a','a','a','a','a','a']