package com.study.onehundred;

import java.util.HashMap;
import java.util.Map;

/**
 *Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 *
 *
 *
 * example1:
 * Input: 3
 * Output: "III"
 *
 * Input: 4
 * Output: "IV"
 *
 * Input: 9
 * Output: "IX"
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 */
public class L12IntToRoman {

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
}
