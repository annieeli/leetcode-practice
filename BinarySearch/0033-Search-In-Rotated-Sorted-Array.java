/*
 * Problem: Search in Rotated Sorted Array
 *
 * You are given an integer array nums sorted in ascending order with distinct
 * values. Before being passed to the function, nums is rotated at an unknown
 * pivot index k (1 <= k < nums.length), resulting in the array
 * [nums[k], nums[k + 1], ..., nums[n - 1], nums[0], ..., nums[k - 1]].
 *
 * Given the rotated array nums and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with $O(\log n)$ runtime complexity.
 * 
 * Examples:
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 */

public class Main {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = (right-left)/2 + left;

            if(nums[mid] == target){
                return mid;
            }

            //check if left is sorted
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }

            //if not, right is sorted
            else{
                if(nums[mid] > target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

        }

        return -1;

    }
}

// Time complexity: O(logn)
// Space complexity: O(1)
// Test cases: ([1], 1), ([1,2,3],4), ([2,3,1],2), ([2,3,1],1)