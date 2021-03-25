package org.cdp.skill.leetcode;

/**
 * 122 买卖股票的最佳时机
 * Best Time to Buy and Sell Stock II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * 给定一个数组，它的第i个元素是一支给定股票第i天的价格。
 * 设计一个算法来计算你所能获取的最大利润。
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例1
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，
 * 在第 3 天（股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，
 * 在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 最后 3 + 4 = 7
 *
 * 示例2
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，
 * 在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 官方的动态规划和贪心都没怎么理解,倒是评论里的一种贪心算法理解了;
 *
 *
 */
public class BestTimeToBuyAndSellStockII {

  // 思路一 动态规划
  static
  class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int[][] dp = new int[n][2];
      dp[0][0] = 0;
      dp[0][1] = -prices[0];
      for (int i = 1; i < n; ++i) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
      }
      return dp[n - 1][0];
    }
  }

  // 思路二 贪心法 炒股必发财法 不考虑交易受限
  static
  class SolutionFacai {
    public int maxProfit(int[] arr) {
      if (arr == null || arr.length <= 1) return 0;

      int ans = 0;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] > arr[i-1]) {  // 卖出有利可图
          ans += (arr[i] - arr[i-1]);
        }
      }
      return ans;
    }
  }

  static
  class SolutionTan {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int dp0 = 0, dp1 = -prices[0];
      for (int i = 1; i < n; ++i) {
        int newDp0 = Math.max(dp0, dp1 + prices[i]);
        int newDp1 = Math.max(dp1, dp0 - prices[i]);
        dp0 = newDp0;
        dp1 = newDp1;
      }
      return dp0;
    }
  }

  public static void main(String[] args) {
    int result1 = new Solution().maxProfit(new int[]{7,1,5,3,6,4});
    System.out.println(result1);

    int result2 = new SolutionFacai().maxProfit(new int[]{7,1,5,3,6,4});
    System.out.println(result2);
  }
}
