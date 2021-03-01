package org.cdp.skill.leetcode;

/**
 * 69 x 的平方根
 * Sqrt x
 * https://leetcode-cn.com/problems/sqrtx
 *
 * 实现int sqrt(int x)函数。
 * 计算并返回x,其中x是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 输入: 4
 * 输出: 2
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 *
 * 思路
 * 二分查找
 * 由于 x 平方根的整数部分 ans 是满足 k^2 < x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案。
 * 就是找到 0 与 x 数的中间值,开始二分迭代,并进行中间值的平方计算,如果结果小于等于 x 则覆盖存起来,直到二分迭代结束.
 *
 *
 * 牛顿迭代法
 * 它是一种可以用来快速求解函数零点的方法。
 * 为了叙述方便，我们用 C 表示待求出平方根的那个整数。显然，C 的平方根就是函数 y = f(x) = x^2 - C 的零点;
 * 不懂
 *
 */
public class SqrtX {

  // 二分查找法
  static
  class SolutionBinarySearch {
    public int mySqrt(int x) {
      int l = 0, r = x, ans = -1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        if ((long) mid * mid <= x) {
          ans = mid;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return ans;
    }
  }

  // 牛顿迭代法
  static
  class SolutionNewtonIteration {
    public int mySqrt(int x) {
      if (x == 0) {
        return 0;
      }

      double C = x, x0 = x;
      while (true) {
        double xi = 0.5 * (x0 + C / x0);
        if (Math.abs(x0 - xi) < 1e-7) {
          break;
        }
        x0 = xi;
      }
      return (int) x0;
    }
  }

  public static void main(String[] args) {
    SolutionBinarySearch solutionBinarySearch = new SolutionBinarySearch();

    int result = solutionBinarySearch.mySqrt(8);
    System.out.println(result);
  }
}
