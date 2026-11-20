/*
* - Problem: Can Place Flowers
*
* You have a long flowerbed in which some of the plots are planted, and some 
* are not. However, flowers cannot be planted in adjacent plots.
*
* Given an integer array flowerbed containing 0's and 1's, where 0 means empty 
* and 1 means not empty, and an integer n, return true if n new flowers can be 
* planted in the flowerbed without violating the no-adjacent-flowers rule and 
* false otherwise.
*
* Example 1:
* Input: flowerbed = [1,0,0,0,1], n = 1
* Output: true
*
* Example 2:
* Input: flowerbed = [1,0,0,0,1], n = 2
* Output: false
*/

class Main {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;

        int counter = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == 3) {
                n--;
                if (n == 0) 
                    return true;
                counter = 1;
            }
        }

        if (counter == 2) {
            n--;
        }

        return n <= 0;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
// Test cases: flowerbed = [0,0,1,0,0], n = 1; flowerbed = [0,0,1,1,1], n = 1