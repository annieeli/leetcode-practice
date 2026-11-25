/*
- Problem: Find the Highest Altitude
 *
- There is a biker going on a road trip. The road trip consists of n + 1 points 
- at different altitudes. The biker starts his trip on point 0 with altitude 
- equal 0.
 *
- You are given an integer array gain of length n where gain[i] is the net gain 
- in altitude between points i and i + 1 for all (0 <= i < n). Return the 
- highest altitude of a point.
 *
- Example 1:
- Input: gain = [-5,1,5,0,-7]
- Output: 1
 *
- Example 2:
- Input: gain = [-4,-3,-2,-1,4,3,2]
- Output: 0
*/

class Main {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for(int i = 0; i < gain.length; i++){
            current += gain[i];
            max = Math.max(current, max);
        }

        return max;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: gain = [-5,-4,-3]; gain = [1,2,3,4]; gain = [0]