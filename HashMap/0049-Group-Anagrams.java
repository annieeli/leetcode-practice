/*
 * Problem: Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of 
 * a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
*/

class Main {
    public List<List<String>> groupAnagrams(String[] strs) {
        //frequency, words
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] curr = new int[26];
            for(char c : str.toCharArray()){
                curr[c-'a']++;
            }

            String key = curr.toString();
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

// Time complexity: O(N * K), N = # of elements in strs[], K = length of longest str
// Space complexity: O(N * K)
// Test cases: [""],["","b"],["abc","bca","acab"]