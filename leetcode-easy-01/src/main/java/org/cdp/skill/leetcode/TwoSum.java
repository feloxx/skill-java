package org.cdp.skill.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * Two Sum
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 *
 */
public class TwoSum {

  // 第一种解法
  static
  class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] res = new int[2];
      if (nums == null || nums.length <= 1) {
        return res;
      } else {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
          int num = nums[i];
          int judge = target - num;
          if (tempMap.containsKey(judge)) {
            res[0] = i;
            res[1] = tempMap.get(judge);
            return res;
          } else {
            tempMap.put(num, i);
          }
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] test1 = new int[]{2, 7, 11, 15};
    int test2 = 9;

    int[] result = solution.twoSum(test1, test2);

    System.out.println(Arrays.toString(result));
  }
}
