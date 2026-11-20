package Greedy;

/*
- Problem: Increasing Triplet Subsequence
 *
- Given an integer array nums, return true if there exists a triple of indices 
- (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such 
- indices exists, return false.
 *
- Example 1:
- Input: nums = [1,2,3,4,5]
- Output: true
 *
- Example 2:
- Input: nums = [5,4,3,2,1]
- Output: false
 *
- Example 3:
- Input: nums = [2,1,5,0,4,6]
- Output: true
*/

class Main {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(first >= nums[i]){
                first = nums[i];
            }

            else if(second >= nums[i]){
                second = nums[i];
            }

            else{
                return true;
            }
        }

        return false;
    }
}

// Time complexity: O(n), where n is nums.length
// Space complexity: O(1)
// Test cases: nums = [1,1,1,1]; nums = [20,100,10,12,5,13]; nums = [1,2]