package com.study.twohundred;

/**
 * @Author pangyangyang
 * @Date 2020/05/26
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 **/
public class L287FindDuplicate {

  public static int findDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[Math.abs(nums[i])] < 0) {
        return -nums[i];
      }
      nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
    }
    return -1;
  }

  /**
   * 快慢指针
   * @param nums
   * @return
   */
  public static int findDuplicate1(int[] nums) {
    int fast = 0, slow = 0;
    while (true) {
      fast = nums[nums[slow]];

    }
  }

  public static void main(String[] args) {

  }
}
