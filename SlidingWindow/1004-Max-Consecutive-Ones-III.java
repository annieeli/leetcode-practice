/*
- Problem: Max Consecutive Ones III
 *
- Given a binary array nums and an integer k, return the maximum number of 
- consecutive 1's in the array if you can flip at most k 0's.
 *
- Example 1:
- Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
- Output: 6
 *
- Example 2:
- Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
- Output: 10
*/

class Main {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int counterK = 0;
        int current = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                current++;
            }
            else{
                counterK++;
                current++;
            }

            while (counterK > k){
                if(nums[i-current+1] == 0){
                    counterK--;
                }
                current--;
            }

            max = Math.max(current, max);
        }

        return max;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: nums = [0,0,0,0], k = 0; nums = [1,1,1,1], k = 2; nums = [0,0,1,1], k = 4