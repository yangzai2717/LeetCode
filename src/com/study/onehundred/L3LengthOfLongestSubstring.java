package com.study.onehundred;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string, find the length of the longest substring without repeating characters.
*
example1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

example2：
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

example3：
* Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

* */
public class L3LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i) + 1));
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i -j +1);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
