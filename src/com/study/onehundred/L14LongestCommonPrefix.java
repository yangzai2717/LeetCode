package com.study.onehundred;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class L14LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return null;
    }
    int i = 0, k = 0;
    for (; k < strs[0].length(); k++) {
      boolean flag = true;
      char chars = strs[0].charAt(k);
      while (flag) {
        if (i == strs.length) {
          i = 0;
          break;
        }
        String curStr = strs[i];
        if (k >= curStr.length()) {
          return strs[0].substring(0, k);
        }
        if (curStr.charAt(k) == chars) {
          i++;
        } else {
          return strs[0].substring(0, k);
        }
      }
    }
    return strs[0].substring(0, k);
  }

  public static void main(String[] args) {
    String[] strs = {"flower"};
    String s = longestCommonPrefix(strs);
    System.out.println(s);
  }
}
