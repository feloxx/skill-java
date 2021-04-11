package org.cdp.skill.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 136 只出现一次的数字
 * Single Number
 * https://leetcode-cn.com/problems/single-number
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例1
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 思路
 * 比较简单的就是考虑先排序,再顺序比较,因为排序后相同的数就已经挨在一起;
 * 这样的话,都要额外使用O(n)的空间;
 *
 * 另一个黑科技思路就是位运算 异或
 * 1. 任何数和0做异或运算,结果仍然是原来的数,a^0=a;
 * 2. 任何数和其自身做异或运算,结果是0,a^a=0;
 * 3. 异或运算满足交换律和结合律,a^b^a == b^a^a == b^(a^a) == b^0 == b
 *
 * 很关键的点,同一个数做两次异或是等于0的
 * 那么我们可以定义一个中间数为0,用于异或和暂存异或结果
 * 有序遍历数组,每个元素与中间数异或,结果重新赋值到中间数中
 * 最后结果有2可能
 * 第1可能 相同的数异或结果都是0,0累加还是会等于0
 * 第2可能 不相同的数再与0异或,则会得到自己,0累加则会得到不同的数
 */
public class SingleNumber {

  // 使用排序的方式(内置排序)
  static
  class Solution {
    public int singleNumber(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }
      if (nums.length <= 0) {
        return -1;
      }

      Arrays.sort(nums);
      System.out.println(Arrays.toString(nums));
      for (int i = 0; i < nums.length; i++) {
        // 返回右边
        if(i == nums.length - 1){
          return nums[i];
        }

        // 返回左边
        if (nums[i] != nums[i + 1]) {
          return nums[i];
        } else {
          i++;
        }
      }

      return -1;
    }
  }

  // 使用黑科技 异或
  static
  class SolutionEO {
    public int singleNumber(int[] nums) {
      int single = 0;
      for (int num : nums) {
        single ^= num;
      }
      return single;
    }
  }

  public static void main(String[] args) {
    int[] test1 = new int[]{2, 1, 2};
    int[] test2 = new int[]{4,1,2,1,2};
    int result1 = new Solution().singleNumber(test2);
    System.out.println(result1);

    int result2 = new SolutionEO().singleNumber(test2);
    System.out.println(result2);
  }
}
