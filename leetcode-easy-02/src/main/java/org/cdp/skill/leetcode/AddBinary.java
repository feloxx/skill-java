package org.cdp.skill.leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.ArrayUtils;

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
 * 可以先把2进制转换成10进制,计算完后再转换回去
 */
public class AddBinary {

  // 自己想的
  // 11 98, 10 01 97, 00 96
  static
  class Solution {
    public String addBinary(String a, String b) {
//      char[] arrA = a.toCharArray();
//      char[] arrB = b.toCharArray();
//
//      int maxLen = 0;
//      if (arrA.length > arrB.length) maxLen = arrA.length;
//      else maxLen = arrB.length;
//
//      String result = "";
//
//
//      for (int i = maxLen - 1; i >= 0; i--) {
//        if (arrA[i] + arrB[i] == 98) {
//          result += "0";
//        } else if (arrA[i] + arrB[i] == 97) {
//          result += "1";
//        } else {
//          result += "0";
//        }
//
//      }
//
//
//
//      return new StringBuffer(result).reverse().toString();
      int intA = Integer.parseInt(a, 2);
      int intB = Integer.parseInt(b, 2);
      int tempResult = intA + intB;

      return Integer.toBinaryString(tempResult);
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
