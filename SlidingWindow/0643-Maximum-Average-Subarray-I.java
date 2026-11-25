/*
- Problem: Maximum Average Subarray I
 *
- You are given an integer array nums consisting of n elements, and an integer k.
 *
- Find a contiguous subarray whose length is equal to k that has the maximum 
- average value and return this value. Any answer with a calculation error less 
- than 10^-5 will be accepted.
 *
- Example 1:
- Input: nums = [1,12,-5,-6,50,3], k = 4
- Output: 12.75000
 *
- Example 2:
- Input: nums = [5], k = 1
- Output: 5.00000
*/

class Main {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;

        double maxAverage = 0;
        
        for(int i = 0; i < right; i++){
            maxAverage += nums[i];
        }

        double lastAverage = maxAverage;

        while(right < nums.length){
            double currentAverage = lastAverage + nums[right] - nums[left];

            maxAverage = Math.max(maxAverage, currentAverage);

            left++;
            right++;

            lastAverage = currentAverage;
        }

        return (double)maxAverage/k;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: nums = [-1], k = 1; nums = [-5,-2,-3,-1], k = 2; nums = [0,4,0,3,2], k = 1