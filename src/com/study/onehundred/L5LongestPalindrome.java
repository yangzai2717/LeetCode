package com.study.onehundred;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

example1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

example2:
Input: "cbbd"
Output: "bb"
* */
public class L5LongestPalindrome {

    //暴力解决法
    public static String longestPalindrome1(String s) {
        int res = 0;
        String restr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + res; j < s.length(); j++) { //j = i + res :可以裁剪，小于res的就直接不用判断了
                if (isPalindromel(s.substring(i, j+1))) {
                    String ss = s.substring(i, j+1);
                    if (res < ss.length()) {
                        res = ss.length();
                        restr = ss;
                    }
                }
            }
        }
        return restr;
    }

    public static boolean isPalindromel(String s) {
        int i = 0, j = s.length() - 1;
        while (i<=j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    //动态规划法
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (s.length() < 2) {
            return s;
        }

        boolean[][] bp = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            bp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i  < 3) {
                        bp[i][j] = true;
                    }else {
                        bp[i][j] = bp[i+1][j-1];
                    }
                }else {
                    bp[i][j] = false;
                }

                if (bp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "abba";
        long start = System.currentTimeMillis()/(1000);
        System.out.println(longestPalindrome2(s));
        long end = System.currentTimeMillis()/(1000);
        System.out.println(end- start);
    }
}
