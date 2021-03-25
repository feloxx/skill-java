package org.cdp.skill.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 杨辉三角II
 * Pascal's Triangle II
 * https://leetcode-cn.com/problems/pascals-triangle-ii
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalsTriangle2 {

  static
  class Solution {
    public List<Integer> getRow(int rowIndex) {
      List<List<Integer>> result = new ArrayList<>();

      for (int i = 0; i < rowIndex + 1; i++) {
        List<Integer> internal = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
          if (j == 0 || j == i) {
            internal.add(1);
          } else {
            internal.add(
              result.get(i - 1).get(j - 1)
                + result.get(i - 1).get(j)
            );
          }
        }
        result.add(internal);
      }
      System.out.println(result);
      return result.get(rowIndex);
    }
  }

  // 滚动数组思想
  static
  class SolutionSliding {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> pre = new ArrayList<>();

      for (int i = 0; i <= rowIndex; i++) {
        List<Integer> internal = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
          if (j == 0 || j == i) {
            internal.add(0);
          } else {
            internal.add(pre.get(j - 1) + pre.get(j));
          }
        }
        pre = internal;
      }
      return pre;
    }
  }

  // 用一个数组,最后一位会多一个0需要截取一下,但是这种方式没太理解
  // 相当于正序生成数组,然后倒序去叠加计算
  static
  class SolutionSingleList {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> row = new ArrayList<>();
      row.add(1);
      for (int i = 0; i <= rowIndex; ++i) {
        row.add(0);
        for (int j = i; j > 0; --j) {
          row.set(j, row.get(j) + row.get(j - 1));
        }
      }
      return row.subList(0, row.size() - 1);
    }
  }

  static
  class SolutionLinePush {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> row = new ArrayList<Integer>();
      row.add(1);
      for (int i = 1; i <= rowIndex; ++i) {
        row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
      }
      return row;
    }
  }

  public static void main(String[] args) {
    List<Integer> result1 = new Solution().getRow(4);
    System.out.println(result1);

    List<Integer> result2 = new SolutionSliding().getRow(4);
    System.out.println(result2);

    List<Integer> result3 = new SolutionSingleList().getRow(4);
    System.out.println(result3);
  }
}
