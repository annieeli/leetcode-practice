/*
- Problem: Find the Difference of Two Arrays
 *
- Given two integer arrays nums1 and nums2, return a list containing two 
- sublists:
- 1. All unique values in nums1 that do not appear in nums2.
- 2. All unique values in nums2 that do not appear in nums1.
- Elements in each sublist may be returned in any order.
 *
- Example 1:
- Input: nums1 = [1, 2, 3], nums2 = [2, 4, 6]
- Output: [[1, 3], [4, 6]]
 *
- Example 2:
- Input: nums1 = [1, 2, 3, 3], nums2 = [1, 1, 2, 2]
- Output: [[3], []]
*/

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Main {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        for(Integer elem : set1){
            if(!set2.contains(elem)){
                list1.add(elem);
            }
        }

        for(Integer elem : set2){
            if(!set1.contains(elem)){
                list2.add(elem);
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        output.add(list1);
        output.add(list2);

        return output;
    }
}

// Time complexity: O(n + m)
// Space complexity: O(n + m)
// Test cases: nums1 = [1,1,1], nums2 = [1,1]; nums1 = [-1,0,1], nums2 = [2,3]; nums1 = [5], nums2 = [5]