/*
 * Problem: Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen 
 * numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen 
 * numbers is different.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
*/

public class Main {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        backtracking(combination, target, candidates, new ArrayList<>(), 0);
        return combination;
    }

    private void backtracking(List<List<Integer>> combination, int remain, int[] candidates, 
        List<Integer> currentComb, int start){

        if(remain < 0){
            return;
        }

        if(remain == 0){
            combination.add(new ArrayList<>(currentComb));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            currentComb.add(candidates[i]);
            backtracking(combination, remain-candidates[i], candidates, currentComb, i);
            currentComb.remove(currentComb.size()-1);
        }
    }
}

// Time complexity: O(N^(T/M)) - N = # of elements in candidates[], T = target, M = min value of candidates
// Space complexity: O(T/M)
// Test cases: candidates = [2], target = 7; candidates = [2], target = 2; candidates = [3,6,7], target = 2; candidates = [], target = 7