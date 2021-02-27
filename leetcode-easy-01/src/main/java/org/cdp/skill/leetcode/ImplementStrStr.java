package org.cdp.skill.leetcode;

/**
 * 28 实现strStr()函数
 * Implement strStr()
 *
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 说明:
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
 *
 * 这一题还会引出很经典的KMP算法?
 *
 * KMP算法的操作流程
 *
 * 假设现在文本串 S 匹配到 i 位置，模式串 P 匹配到 j 位置
 * 如果 j = -1，或者当前字符匹配成功（即 S[i] == P[j] ），都令 i++，j++，继续匹配下一个字符；
 * 如果 j != -1，且当前字符匹配失败（即 S[i] != P[j] ），则令 i 不变，j = next[j]。此举意味着失配时，模式串 P相对于文本串 S 向右移动了 j - next [j] 位
 * 换言之，将模式串 P 失配位置的 next 数组的值对应的模式串 P 的索引位置移动到失配处
 */
public class ImplementStrStr {

  // 滑动窗口
  // for循环中的 start < origin - match + 1 的目的是防止数组越界,因为要匹配的窗口与原窗口移动的最后匹配的头一位下标为 origin - match + 1
  static
  class Solution {
    public int strStr(String haystack, String needle) {
      int origin = haystack.length(), match = needle.length();

      for (int start = 0; start < origin - match + 1; ++start) {
        if (haystack.substring(start, start + match).equals(needle)) {
          return start;
        }
      }
      return -1;
    }
  }

  // 内置函数
  static
  class SolutionInternal {
    public int strStr(String haystack, String needle) {
      return haystack.indexOf(needle);
    }
  }

  // kmp算法
  static
  class SolutionKMP {
    public int strStr(String haystack, String needle) {
      if (needle.equals("")) return 0;
      int n1 = haystack.length(), n2 = needle.length();
      int[] next = new int[n2];
      getNext(next, needle);//计算子串中回退的位置
      int i = 0, j = 0;
      while (i < n1 && j < n2) {
        if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
          i++;
          j++;
        } else {
          j = next[j];//j回退
        }
        if (j == n2) return i - n2;

      }
      return -1;
    }

    public void getNext(int[] next, String t) {
      //找到每个字符的前一个匹配位置
      int j = 0, k = -1;
      next[0] = -1;
      while (j < t.length() - 1) {
        if (k == -1 || t.charAt(j) == t.charAt(k)) {
          k++;
          j++;
          next[j] = k;//如果匹配则前一个匹配位置为k,否则说明k在开头，则next[j]=0
        } else {
          k = next[k];//k调到上一个位置重新匹配
        }
      }
    }
  }


  public static void main(String[] args) {
    Solution solution = new Solution();

    String test1 = "hello", test2 = "ll";
    int result = solution.strStr(test1, test2);

    System.out.println(result);
  }
}
