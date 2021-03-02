package org.cdp.skill.leetcode;

import java.util.ArrayList;

/**
 * 70 爬楼梯
 * Climbing Stairs
 * https://leetcode-cn.com/problems/climbing-stairs
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 从数学层面去理解,是一个斐波那契数列,所以有两种方式计算,循环版和递归版,但是需要注意精度问题;
 *
 * 另一个说有啥矩阵快速幂,这个暂时还不理解;
 */
public class ClimbingStairs {

  // 循环版
  static
  class Solution {

    public int climbStairs(int n) {
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(0, 1);
      temp.add(1, 1);

      for(int i = 2 ; i <= n ; i ++) {
        int r = temp.get(i - 1) + temp.get(i - 2);
        temp.add(i, r);
      }

      return temp.get(n);
    }
  }

  // 以前scala里写的数学递归版
  static
  class SolutionScalaFb {

    public int climbStairs(int n) {
      return fb(n, 0 ,0 , 1);
    }
    private int fb(int i, int d, int a, int b) {
      if (d >= i) return b;
      else return fb(i, d + 1, b, a + b);
    }
  }

  // 网上例子版
  static
  class SolutionOther {

    // 没太懂的 数学函数的 裴波那契
    public int climbStairs(int n) {
      double sqrt_5 = Math.sqrt(5);
      double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
      return (int)(fib_n / sqrt_5);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int test1 = 4;

    int result = solution.climbStairs(test1);
    System.out.println(result);
  }
}
