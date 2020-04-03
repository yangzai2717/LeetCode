package com.study.onehundred;

/**
 *Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * example1:
 * Input: 121
 * Output: true
 *
 * example2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * example3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 */
public class L9IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 10 && x >= 0 ) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int preTemp = 0;
        int temp = 0;
        int res = x;
        while (res > 0) {
            temp = temp * 10 + res % 10 ;
            res = res / 10;
            if (temp == res) {
                return true;
            }else if (preTemp == res) {
                return true;
            }
            preTemp = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(0);
        System.out.println(palindrome);
    }
}
