package org.cdp.skill.leetcode;

/**
 * 121 买卖股票的最佳时机
 * Best Time to Buy and Sell Stock
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *
 * 给定一个数组prices，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
 *
 * 示例1
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例2
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 思路
 * 自己想的,首先应该判断是否为降序,如果是降序就返回0
 * 然后如果不是降序,是不是可以从后往前遍历,遇到差集最大就返回各自的下标
 * 但是怎么从后往前遍历呢?滑动窗口遍历么?
 *
 * 官方题解
 * 1 暴力法
 * 我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。
 * 此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
 *
 * 形式上，对于每组 i 和 j（其中 j>i） i为左边的元素, j为i右边的元素
 * 我们需要找出 max(prices[j]−prices[i])。
 *
 * 2 一次遍历法 事后诸葛亮法
 * 我们来假设自己来购买股票。随着时间的推移，每天我们都可以选择出售股票与否。
 * 那么，假设在第 i 天，如果我们要在今天卖股票，那么我们能赚多少钱呢？
 * 显然，如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！
 * 太好了，在题目中，我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
 * 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
 * 因此，我们只需要遍历价格数组一遍，记录历史最低点，
 * 然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
 * 当考虑完所有天数之时，我们就得到了最好的答案。
 *
 * 网友的解释
 * 看来好多人和我一样犯迷糊。
 * 原题解的表述有点模糊，比如历史最低价格，我这里写下我的理解，希望能帮助别人：
 * 假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1] 之间选最低点买入；
 * 所以遍历数组，依次求每个卖出时机的的最大差值，再从中取最大值。
 *
 * 第二种答案是假设某一天要卖，计算与之前的最低点的差，最后找最大值。
 * 而不是先找最低点，再找后面的最高点。
 */
public class BestTimeToBuyAndSellStock {

  // 暴力全排列
  static
  class SolutionViolence {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      // 使用双重循环,对数组进行2位数不考虑顺序的全排列
      // 这样就组成了一对一对需要进行差值的元素
      // 然后进行差值比较,将最大的差值与结果变量比较,谁大就覆盖谁
      for (int i = 0; i < prices.length - 1; i++) {
        for (int j = i + 1; j < prices.length; j++) {
          int profit = prices[j] - prices[i];
          if (profit > maxProfit) {
            maxProfit = profit;
          }
        }
      }
      return maxProfit;
    }
  }

  static
  class SolutionOnce {
    public int maxProfit(int[] prices) {
      int minPrice = Integer.MAX_VALUE;
      int maxPrice = 0;
      for (int price : prices) {
        if (price < minPrice) {
          minPrice = price;
        } else if (price - minPrice > maxPrice) {
          maxPrice = price - minPrice;
        }
      }
      return maxPrice;
    }
  }

  public static void main(String[] args) {
    int result1 = new SolutionOnce().maxProfit(new int[]{7,1,5,3,6,4});
    System.out.println(result1);

    int result2 = new SolutionOnce().maxProfit(new int[]{7,6,4,3,1});
    System.out.println(result2);
  }
}
