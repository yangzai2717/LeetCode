package com.study.onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
* (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
*
example:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

*Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

example:
P     I    N
A   L S  I G
Y A   H R
P     I
*
*
* */
public class L6Convert {

    public static String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        if (s.length() <= numRows || numRows == 1) return s;

        List<StringBuilder> builders = new ArrayList<>(numRows);
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (!flag) {
                if (i < numRows) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(s.charAt(i)));
                    builders.add(sb);
                }else {
                    StringBuilder sb = builders.get(j);
                    sb.append(String.valueOf(s.charAt(i)));
                }
                if (j == numRows - 1) {
                    flag = true;
                    j--;
                }
                j++;
            }else {
                StringBuilder sb = builders.get(--j);
                sb.append(String.valueOf(s.charAt(i)));
                if (j == 0)  {
                    flag = false;
                    j++;
                }
            }
        }
        for (int i = 0; i < builders.size(); i++) {
            res.append(builders.get(i).toString() + "/");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "ab";
        String convert = convert(s, 1);
        System.out.println(convert);
    }
}
