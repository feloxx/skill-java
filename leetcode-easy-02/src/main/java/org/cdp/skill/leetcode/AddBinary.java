package org.cdp.skill.leetcode;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * 67 二进制求和
 * Add Binary
 * https://leetcode-cn.com/problems/add-binary
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 * 示例1
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例2
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 思路:
 *
 * 第一种,使用内置包 Integer 可以先把2进制转换成10进制,计算完后再转换回去
 * 但是这种有缺点,这些内置包都有些精度问题
 * 如果字符串超过 33 位，不能转化为 Integer
 * 如果字符串超过 65 位，不能转化为 Long
 * 如果字符串超过 500000001 位，不能转化为 BigInteger
 *
 * 第二种,列竖式,末尾对齐,逐位相加,根据二进制的原则逢二进一.
 * 最开始我也是这种想法,但是在类型转换上卡了很久
 *
 * 第三种,位运算
 */
public class AddBinary {

  // 自己想的,列竖式
  // 11 98, 10 01 97, 00 96
  static
  class Solution {
    public String addBinary(String a, String b) {

      return "";
    }
  }

  // 官方列竖式
  static
  class SolutionOfficial {
    public String addBinary(String a, String b) {
      StringBuffer ans = new StringBuffer();

      int n = Math.max(a.length(), b.length()), carry = 0;
      for (int i = 0; i < n; ++i) {
        carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
        carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
        ans.append((char) (carry % 2 + '0'));
        carry /= 2;
      }

      if (carry > 0) {
        ans.append('1');
      }
      ans.reverse();

      return ans.toString();
    }
  }

  // 使用内置包
  static
  class SolutionInternal {
    public String addBinary(String a, String b) {
      return Integer.toBinaryString(
        Integer.parseInt(a, 2)
          +
          Integer.parseInt(b, 2)
      );
    }
  }

  // 使用位运算 网上例子
  static
  class SolutionPos {
    public String addBinary(String a, String b) {
      BitSet bitsetA = new BitSet(a.length());
      for (int i = 0; i < a.length(); i++) {
        bitsetA.set(i, a.charAt(a.length() - i - 1) == '1');
      }

      BitSet bitsetB = new BitSet(b.length());
      for (int i = 0; i < b.length(); i++) {
        bitsetB.set(i, b.charAt(b.length() - i - 1) == '1');
      }

      while (!bitsetA.isEmpty()) {
        BitSet tempB = BitSet.valueOf(bitsetB.toLongArray());
        bitsetB.xor(bitsetA); // 执行逻辑异或设置该位集合参数
        bitsetA.and(tempB);

        BitSet newA = new BitSet(bitsetA.length() + 1);
        bitsetA.stream().forEach(i -> newA.set(i + 1, true));
        bitsetA = newA;
      }

      StringBuilder ret = new StringBuilder();
      IntStream.range(0, bitsetB.length())
        .mapToObj(i -> bitsetB.get(i) ? '1' : '0')
        .forEach(ret::append);

      return ret.length() == 0 ? "0" : ret.reverse().toString();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String test1 = "101";
    String test2 = "11";

    String result = solution.addBinary(test1, test2);
    System.out.println(result);
  }
}
