/*
- Problem: Max Number of K-Sum Pairs
 *
- You are given an integer array nums and an integer k.
 *
- In one operation, you can pick two numbers from the array whose sum equals k 
- and remove them from the array.
 *
- Return the maximum number of operations you can perform on the array.
 *
- Example 1:
- Input: nums = [1,2,3,4], k = 5
- Output: 2
 *
- Example 2:
- Input: nums = [3,1,3,4,3], k = 6
- Output: 1
*/

import java.util.HashMap;

class Main {
    public int maxOperations(int[] nums, int k) {
        int maxOperation = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int difference = k - nums[i];
            if(map.containsKey(difference)){
                int count = map.get(difference);
                maxOperation++;
                if(count-1 <= 0)
                    map.remove(difference);
                else
                    map.put(difference, count-1);
            }
            else{
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }

        return maxOperation;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: nums = [2,2,2,2], k = 4; nums = [1], k = 2; nums = [1,1,1,1], k = 5