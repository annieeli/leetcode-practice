/*
- Problem: Longest Subarray of 1's After Deleting One Element
 *
- Given a binary array nums, you should delete one element from it.
 *
- Return the size of the longest non-empty subarray containing only 1's in the 
- resulting array. Return 0 if there is no such subarray.
 *
- Example 1:
- Input: nums = [1,1,0,1]
- Output: 3
 *
- Example 2:
- Input: nums = [0,1,1,1,0,1,1,0,1]
- Output: 5
 *
- Example 3:
- Input: nums = [1,1,1]
- Output: 2
*/

class Main {
    public int longestSubarray(int[] nums) {
        int deleted = 0;
        int current = 0;
        int max = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                current++;
            }
            else{
                deleted++;
            }

            while(deleted > 1){
                if(left < nums.length && nums[left] == 0){
                    deleted--;  
                }
                else if(left < nums.length && nums[left] == 1){
                    current--;
                }
                left++;
            }

            max = Math.max(max, current);
        }

        if(deleted == 0)
            return max-1;
        return max;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: nums = [0,0,0]; nums = [1]; nums = [1,1,0,0,1,1,1,0,1]