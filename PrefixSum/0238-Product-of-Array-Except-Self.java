/*
 * Problem: Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] 
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Constraint: You must write an algorithm that runs in O(n) time and 
 * without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Explanation: 
 * For index 0: 2 * 3 * 4 = 24
 * For index 1: 1 * 3 * 4 = 12
 * For index 2: 1 * 2 * 4 = 8
 * For index 3: 1 * 2 * 3 = 6
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
*/

public class Main {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;

        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i-1] * left[i-1];
        }

        for(int i = nums.length-2; i >= 0; i--){
            right[i] = nums[i+1] * right[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            left[i] *= right[i];
        }

        return left;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: [], [1,2,3],[-1,-1,2,3],[4,0,5]