package org.cdp.skill.leetcode;

/**
 * 没理解
 *
 * 38 外观数列
 * Count and Say
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
