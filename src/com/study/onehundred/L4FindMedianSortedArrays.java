package com.study.onehundred;

import java.util.Vector;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

example1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

example2
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5


* */
public class L4FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            int[] nums3 = nums1.length == 0 ? nums2 : nums1;
            if (nums3.length % 2 == 0) {

                return ((double) nums3[nums3.length/2] + (double) nums3[(nums3.length/2) - 1]) / 2;
            }else {
                return nums3[nums3.length/2];
            }
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len3 = nums1.length + nums2.length;
        int mid = len3 / 2;
        int cart1 = 0, cart2 = mid - cart1;
        double median;
        int leftMaxA = cart1 == 0 ? Integer.MIN_VALUE : nums1[cart1-1];
        int minRigA = cart1 == nums1.length ? Integer.MAX_VALUE : nums1[cart1];

        int leftMaxB = cart2 == 0 ? Integer.MIN_VALUE : nums2[cart2-1];
        int minRigB = cart2 == nums2.length ? Integer.MAX_VALUE : nums2[cart2];
        while (leftMaxA > minRigB || leftMaxB > minRigA) {
            cart1++;
            cart2 = mid - cart1;

            leftMaxA = cart1 == 0 ? Integer.MIN_VALUE : nums1[cart1 -1 ];
            minRigA = cart1 == nums1.length ? Integer.MAX_VALUE : nums1[cart1];

            leftMaxB = cart2 == 0 ? Integer.MIN_VALUE : nums2[cart2 -1];
            minRigB = cart2 == nums2.length ? Integer.MAX_VALUE : nums2[cart2];
        }
        if (len3 % 2 == 0) {
            double leftMax = Math.max(leftMaxA, leftMaxB);
            double rigMin = Math.min(minRigA, minRigB);
            median = (leftMax + rigMin ) / 2;
        }else {
            median = Math.min(minRigA, minRigB);
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,4};
        int[] nums2 = new int[]{1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}