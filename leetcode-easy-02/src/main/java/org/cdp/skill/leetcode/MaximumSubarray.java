package org.cdp.skill.leetcode;

/**
 * 没理解
 *
 * 53 最大子序和
 * Maximum Subarray
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 *
 *
 * 滚动数组的思路
 *
 * 不难给出一个时间复杂度 O(n)、空间复杂度 O(n) 的实现，即用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。
 * 考虑到 f(i) 只和 f(i−1) 相关，
 * 于是我们可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。
 *
 */
public class MaximumSubarray {

  // 滚动数组
  static
  class Solution {
    public int maxSubArray(int[] nums) {
      int pre = 0, maxAns = nums[0];
      for (int x : nums) {
        pre = Math.max(pre + x, x);
        maxAns = Math.max(maxAns, pre);
      }
      return maxAns;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] test1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};

    int result = solution.maxSubArray(test1);
    System.out.println(result);
  }
}
