package org.cdp.skill.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 14 最长公共前缀
 * Longest Common Prefix
 * https://leetcode-cn.com/problems/longest-common-prefix
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {

  // 自己的实现思路
  static
  class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs.length <= 0) return "";
      if (strs.length == 1) return strs[0];

      StringBuilder result = new StringBuilder();
      for (int i = 0; i < Arrays.stream(strs).min(String::compareTo).get().length(); i++) {
        HashMap<Character, Integer> check = new HashMap<>();
        for (String str : strs) {
          check.put(str.toCharArray()[i], 1);
        }
        if (check.size() == 1) result.append(check.keySet().toArray()[0].toString());
        else return result.toString();
        check.clear();
      }
      return result.toString();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] test1 = new String[]{
      "hello"
      , "helll"
      , "heooi"
    };

    System.out.println(solution.longestCommonPrefix(test1));

  }
}
