/*
- Problem: Move Zeroes
 *
- Given an integer array nums, move all 0's to the end of it while maintaining 
- the relative order of the non-zero elements.
 *
- Note that you must do this in-place without making a copy of the array.
 *
- Example 1:
- Input: nums = [0,1,0,3,12]
- Output: [1,3,12,0,0]
 *
- Example 2:
- Input: nums = [0]
- Output: [0]
*/

class Main {
    public void moveZeroes(int[] nums) {
        int read = 0;
        int write = 0;

        while (read < nums.length) {
            if (nums[read] != 0) {
                if (read != write) {
                    int temp = nums[write];
                    nums[write] = nums[read];
                    nums[read] = temp;
                }
                write++;
            }

            read++;
        }
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: nums = [1,2,0]; nums = [0,0,1]; nums = [1,2,3]