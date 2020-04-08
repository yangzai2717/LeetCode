package com.study.onehundred;

/**
 *Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *

 *
 * example1:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 *
 */
public class L11MaxArea {

    public static int maxArea(int[] height) {
        if (height.length == 0 ) {
            return 0;
        }
        int maxArea = 0, i = 1, j = height.length;
        while (i < j) {
            int temp = (j - i) * (height[i-1] < height[j-1] ? height[i-1] : height[j-1]);
            if (temp > maxArea) {
                maxArea = temp;
            }
            if (height[i-1] < height[j-1]) {
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
