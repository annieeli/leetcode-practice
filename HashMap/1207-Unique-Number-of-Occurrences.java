/*
- Problem: Unique Number of Occurrences
 *
- Given an array of integers arr, return true if the number of occurrences of 
- each value in the array is unique, or false otherwise.
 *
- Example 1:
- Input: arr = [1,2,2,1,1,3]
- Output: true
 *
- Example 2:
- Input: arr = [1,2]
- Output: false
 *
- Example 3:
- Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
- Output: true
*/

import java.util.HashMap;
import java.util.HashSet;

class Main {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        return set.size() == map.values().size();
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: arr = [1]; arr = [1,2,2,1]; arr = [0,0,0,0]