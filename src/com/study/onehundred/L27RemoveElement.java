package com.study.onehundred;

/**
 * @Author pangyangyang
 * @Date 2020/06/03
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 **/
public class L27RemoveElement {

  public static int removeElement(int[] nums, int val) {
    if(nums.length == 0) {
      return 0;
    }
    int i = 0, j = 0;
    while(j < nums.length) {
      if(nums[j] == val) {
        nums[i] = nums[i+1];
        j++;
      }else {
        j++;
        i++;
      }
    }
    return i;
  }

  public static void main(String[] args) {
    int[] nums = {0};
    int i = removeElement(nums, 0);
    System.out.println(i);
  }
}
