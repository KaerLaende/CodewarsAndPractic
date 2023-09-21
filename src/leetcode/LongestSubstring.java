package leetcode;
/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mapChars = new HashMap<>();
        int start = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Character symbol = s.charAt(i);
            if (mapChars.containsKey(symbol)) {
                start = Math.max(start, mapChars.get(symbol)+1);
            }
                mapChars.put(symbol,i);
                 result= Math.max(result,i-start+1);

        }
        return result;
    }

    public static void main(String[] args) {
        String abcabcbb= "abcabcbb";
        System.out.println(lengthOfLongestSubstring(abcabcbb));
    }

}
