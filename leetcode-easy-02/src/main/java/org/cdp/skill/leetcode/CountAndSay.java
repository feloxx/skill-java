package org.cdp.skill.leetcode;

/**
 * 没理解
 *
 * 38 外观数列
 * Count and Say
 * https://leetcode-cn.com/problems/count-and-say
 *
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 1 <= n <= 30
 *
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。
 * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 * 例如，数字字符串 "3322251" 的描述如下图：
 *
 * 23 32 15 11
 *
 *
 * 例子
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 *
 * -------------
 *
 * 这是对外观数列的解释
 *
 * 规律就是对数的描述。11表示有1个1；21表示有2个1；1211表示1个2，1个1。
 * 1987 年， 康威（John Conway） 发现，在这个数列中，相邻两数的长度之比越来越接近一个固定的数。最终，数列的长度增长率将稳定在 30% 左右。
 * 当n趋于无穷大时，该比值为一个常数，记为λ，约等于1.303577。这个常数就叫做康威常数。而且这个数列有个特性，4永远都不会出现。
 *
 * -------------
 *
 * 若你是第一次听到这个问题，你一定会非常喜欢问题的答案：
 * 下一个数是对上一个数的描述，比方说 1211 里有 “ 1 个 1 ， 1 个 2 ， 2 个 1 ” ，那么 111221 就是它的下一个数。
 * 通常我们把这个数列叫做“外观数列”。
 * 作为一个让人拍案叫绝的智力游戏，外观数列的故事似乎就已经到此为止了。
 * 可是，人们渐渐发现，外观数列里面还大有文章可做。
 * 例如，数列中的数虽然会越来越长，但数字 4 始终不会出现。这些优雅的性质成功地引来了数学家们的围观。
 * 在对外观数列的研究中，最引人注目的成果之一要归功于英国数学家 John Conway 。
 * 1987 年，John Conway 发现，在这个数列中，相邻两数的长度之比越来越接近一个固定的数。
 * 最终，数列的长度增长率将稳定在 30% 左右。
 * 事实上，如果把数列中第 n 个数的长度记作 L_n ，则当 n 趋于无穷大的时候， L_(n+1) / L_n 将趋于一个极限。
 * John Conway 把这个极限用希腊字母 λ 表示，并证明了这个数是 71 次方程
 */
public class CountAndSay {

  static
  class Solution {
    //层层递进想到递归
    public String countAndSay(int n) {
      if (n == 1)  //递归第一件事, 递归结束条件
        return "1";

      String str = countAndSay(n - 1); //上一轮的输出是是下一轮的输入
      StringBuilder sb = new StringBuilder(); //存放当前轮答案, 要用StringBuffer, String如果改变, 底层是复制效率很低
      int len = str.length();
      /*
       * 递归代码最神的地方, 一个循环可以展现出n个嵌套for循环的作用, 可以好好体会
       * 这里的算法在初级算法Lc中经常用到, 当与前一个元素不一样时触发函数
       * 注意从1开始是为了方便对比, 相应的长度也+1方便对比
       **/
      int start = 0; //记录开始下标
      for (int i = 1; i < len + 1; i++) {
        if (i == len) //最后一个元素单独处理
          sb.append(i - start).append(str.charAt(start));
        else if (str.charAt(i) != str.charAt(start)) {  //元素改变触发函数
          sb.append(i - start).append(str.charAt(start));
          start = i; //更新起始下标
        }
      }
      return sb.toString(); //StringBuffer记得要转化为String类型
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int test1 = 4;
    String result = solution.countAndSay(test1);
    System.out.println(result);

  }
}
