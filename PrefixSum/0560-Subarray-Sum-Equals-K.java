/*
 * Problem: Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number 
 * of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
*/

public class Main {
    public int subarraySum(int[] nums, int k) {
        //currentSum, frequency of currentSum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int currentSum = 0;
        int total = 0;

        for(int num : nums){
            currentSum += num;

            if(map.containsKey(currentSum-k)){
                total += map.get(currentSum-k);
            }   
            
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return total;
    }
}




// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: [6,6], k = 6; [-1,1,-1], k = -1; [1], k = 0