/*
- Problem: Find Pivot Index
 *
- Given an array of integers nums, calculate the pivot index of this array.
 *
- The pivot index is the index where the sum of all the numbers strictly to the 
- left of the index is equal to the sum of all the numbers strictly to the 
- index's right.
 *
- If the index is on the left edge of the array, then the left sum is 0 because 
- there are no elements to the left. This also applies to the right edge of the 
- array.
 *
- Return the leftmost pivot index. If no such index exists, return -1.
 *
- Example 1:
- Input: nums = [1,7,3,6,5,6]
- Output: 3
 *
- Example 2:
- Input: nums = [1,2,3]
- Output: -1
 *
- Example 3:
- Input: nums = [2,1,-1]
- Output: 0
*/

class Main {
    public int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];

        sumLeft[0] = 0;
        sumRight[nums.length-1] = 0;
        for(int i = 1; i < nums.length; i++){
            sumLeft[i] = sumLeft[i-1] + nums[i-1];
        }

        for(int i = nums.length-2; i >= 0; i--){
            sumRight[i] = sumRight[i+1] + nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            if(sumLeft[i] == sumRight[i]){
                return i;
            }
        }

        return -1;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: nums = [0]; nums = [-1,-1,-1,0,1,1]; nums = [1,0]