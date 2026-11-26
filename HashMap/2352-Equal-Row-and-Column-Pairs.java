/*
- Problem: Equal Row and Column Pairs
 *
- Given a 0-indexed n x n integer matrix grid, return the number of pairs 
- (ri, cj) such that row ri and column cj are equal.
 *
- A row and column pair is considered equal if they contain the same elements 
- in the same order (i.e., an equal array).
 *
- Example 1:
- Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
- Output: 1
 *
- Example 2:
- Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
- Output: 3
*/

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Main {
    public int equalPairs(int[][] grid) {
        int pairs = 0;
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for(int i = 0; i < grid.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < grid.length; j++){
                list.add(grid[i][j]);
            }
            map.put(list, map.getOrDefault(list, 0)+1);
        }

        for(int j = 0; j < grid.length; j++){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < grid.length; i++){
                list.add(grid[i][j]);
            }
            pairs += map.getOrDefault(list, 0);
        }

        return pairs;
    }
}

// Time complexity: O(n^2)
// Space complexity: O(n^2)
// Test cases: grid = [[1]]; grid = [[1,1],[1,1]]; grid = [[1,2],[3,4]]