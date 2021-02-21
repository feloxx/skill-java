package org.cdp.skill.leetcode;

/**
 * 7. 整数反转
 * Reverse Integer
 *
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[-2^31, 2^31-1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 */
public class ReverseInteger {

  // 第一种解法
  static
  class Solution {
    public int reverse(int x) {
      int ans = 0;
      while (x != 0) {
        if ((ans * 10) / 10 != ans) {
          ans = 0;
          break;
        }
        // 43           2
        ans = ans * 10 + x % 10;
        x = x / 10;
      }
      return ans;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int test1 = 872721;
    int result = solution.reverse(test1);

    System.out.println(test1);
    System.out.println(result);
  }
}
