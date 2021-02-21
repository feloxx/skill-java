package org.cdp.skill.leetcode;

/**
 * 9. 回文数
 * Palindrome Number
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 */
public class PalindromeNumber {

  static
  class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) return false;

      int help = 1;
      int tmp = x;
      while (tmp >= 10) {
        help *= 10;
        tmp /= 10;
      }
      while (x != 0) {
        if (x % 10 != x / help) {
          return false;
        }
        x = x % help / 10;
        help /= 100;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int test1 = 12321;
    int test2 = 1234444;

    System.out.println(solution.isPalindrome(test1));
    System.out.println(solution.isPalindrome(test2));
  }
}
