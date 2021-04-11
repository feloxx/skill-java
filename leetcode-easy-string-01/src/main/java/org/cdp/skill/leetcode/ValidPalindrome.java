package org.cdp.skill.leetcode;

/**
 * 125 验证回文串
 * Valid Palindrome
 * https://leetcode-cn.com/problems/valid-palindrome
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 我们将空字符串定义为有效的回文串。
 *
 * 示例1
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例2
 * 输入: "race a car"
 * 输出: false
 *
 * 这个题主要先考虑,去除不需要的字符,然后转换成小写,要先考虑这一点
 *
 * 回文类的题,解题思路有3个方向
 * 双指针
 * 栈
 * reverse
 *
 * 双指针思路
 * 初始时，左右指针分别指向 sgood 的两侧，随后我们不断地将这两个指针相向移动，
 * 每次移动一步，并判断这两个指针指向的字符是否相同。
 * 当这两个指针相遇时，就说明 sgood 时回文串。
 *
 */
public class ValidPalindrome {

  // 字符串暴力反转比较法 reverse
  static
  class Solution {
    public boolean isPalindrome(String s) {
      String filterStr = s.replaceAll("[^a-zA-Z0-9]","")
        .toLowerCase();

      String reverseStr = new StringBuffer(filterStr).reverse().toString();

      return filterStr.equals(reverseStr);
    }
  }

  // 双指针
  static
  class SolutionDoublePoint {
    public boolean isPalindrome(String s) {
      // 先把字符串过滤成只有数字和字符
      StringBuffer sgood = new StringBuffer();
      int length = s.length();
      for (int i = 0; i < length; i++) {
        char ch = s.charAt(i);
        if (Character.isLetterOrDigit(ch)) {
          sgood.append(Character.toLowerCase(ch));
        }
      }
      int n = sgood.length();
      int left = 0, right = n - 1;
      while (left < right) {
        if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
          return false;
        }
        ++left;
        --right;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    boolean result1 = new Solution().isPalindrome("A man, a plan, a canal: Panama");
    System.out.println(result1);

    boolean result2 = new SolutionDoublePoint().isPalindrome("A man, a plan, a canal: Panama");
    System.out.println(result2);
  }
}
