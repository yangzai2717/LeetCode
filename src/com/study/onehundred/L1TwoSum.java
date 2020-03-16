package com.study.onehundred;

import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*
example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

* */
public class L1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(nums[i])) {
                Integer r1 = map.get(nums[i]);
                result[0] = r1;
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,11};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
