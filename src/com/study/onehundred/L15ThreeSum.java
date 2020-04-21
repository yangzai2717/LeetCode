package com.study.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class L15ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (null == nums || nums.length < 3) {
      return res;
    }
    int len = nums.length;
    Arrays.sort(nums);
    for (int k = 0; k <= len - 3; k++) {
      if (nums[k] > 0) {
        break;
      }
      if (k > 0 && nums[k] == nums[k - 1]) {
        continue;
      }
      int i = k + 1;
      int j = len - 1;
      int cur = nums[k];
      int tar = 0 - cur;
      while (i < j) {
        int lef = nums[i], rig = nums[j];
        if (lef + rig == tar) {
          res.add(Arrays.asList(nums[k], nums[i], nums[j]));
          while (i < j && nums[i] == nums[i + 1]) {
            i++;
          }
          while (i < j && nums[j] == nums[j - 1]) {
            j--;
          }
          i++;
          j--;
        }else if (lef + rig < tar){
          i++;
        }else {
          j--;
        }
      }
    }
    return res;
  }

  public static void sout(List<List<Integer>> list) {
    System.out.println(list.toString());
  }

  public static void main(String[] args) {
    int[] nums = {0, 0, 0};
    List<List<Integer>> lists = threeSum(nums);
    sout(lists);
  }
}
