/*
 * Problem: 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
*/

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];

            while(left < right){

                if(left != i+1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }

                if(right != nums.length-1 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }

                int total = nums[left] + nums[right];
                if(total < target){
                    left++;
                }

                else if (total > target){
                    right--;
                }
                else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplets.add(triplet);

                    left++;
                    right--;
                }
            }
        }

        return triplets;
    }
}



// Time complexity: O(n^2)
// Space complexity: O(n)
// Test cases: [-1,-1,1,0,1,-1], [1,2,3,4,5,-5],[2,3,-2,-4,-1,1]