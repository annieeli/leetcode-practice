/*
 * Problem: Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge all 
 * overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

public class Main {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }

        //sort by first index
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] currPair = intervals[i];
            int[] prevPair = list.get(list.size()-1);

            if(prevPair[0] <= currPair[0] && currPair[0] <= prevPair[1]){
                prevPair[1] = Math.max(currPair[1], prevPair[1]);
            }
            else{
                list.add(currPair);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}

// Time complexity: O(nlogn);
// Space complexity: O(n);
// Test cases: [], [[1,4],[2,3]],[[1,3][2,6]],[[4,6],[2,8]]