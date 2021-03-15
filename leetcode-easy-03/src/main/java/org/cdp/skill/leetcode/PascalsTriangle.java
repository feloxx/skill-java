package org.cdp.skill.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118 杨辉三角
 * Pascal's Triangle
 * https://leetcode-cn.com/problems/pascals-triangle
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * 正好补充一下杨辉三角的特性
 * 每行数字左右对称，由 1 开始逐渐变大再变小，并最终回到 1。
 * 第 n 行（从 0 开始编号）的数字有 n+1 项，前 n 行共有 n(n+1)/2 个数
 * 后面的不知道咋表示了
 */
public class PascalsTriangle {

  static
  class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> result = new ArrayList<>(); // 存放结果的二元数组

      // i 代表行的遍历
      for (int i = 0; i < numRows; ++i) {
        List<Integer> internal = new ArrayList<>();
        // j 代表行里的每一个的数的遍历
        for (int j = 0; j <= i; ++j) {
          if (j == 0 || j == i) {
            internal.add(1); // 第一位恒等于1
          } else {
            internal.add(
              // 第 i 行的第 j 个数等于
              // 第 i−1 行的第 j−1 个数和第 j 个数之和
              result.get(i - 1).get(j - 1)
                + result.get(i - 1).get(j)
            );
          }
        }
        System.out.println(internal.toString());
        result.add(internal);
      }

      return result;
    }
  }

  public static void main(String[] args) {

    List<List<Integer>> result1 = new Solution().generate(5);
    System.out.println(result1);
  }
}
