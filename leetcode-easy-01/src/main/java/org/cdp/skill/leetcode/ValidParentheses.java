package org.cdp.skill.leetcode;

import java.util.Stack;

/**
 * 20 有效的括号
 * Valid Parentheses
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class ValidParentheses {

  static
  class Solution {
    public boolean isValid(String s) {
      if (s.length() % 2 != 0 || s.isEmpty()) return false;

      Stack<Character> stack = new Stack<Character>();
      for (char c : s.toCharArray()) {
        if (c == '(')
          stack.push(')');
        else if (c == '{')
          stack.push('}');
        else if (c == '[')
          stack.push(']');
        else if (stack.empty() || c != stack.pop())
          return false;
      }
      return stack.empty();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String test1 = "()";
    String test2 = "(]";
    String test3 = "(){}}{";

    System.out.println(solution.isValid(test1));
    System.out.println(solution.isValid(test2));
    System.out.println(solution.isValid(test3));
  }
}
