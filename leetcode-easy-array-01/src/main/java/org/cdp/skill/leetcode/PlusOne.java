package org.cdp.skill.leetcode;

/**
 * 66 加一
 * Plus One
 * https://leetcode-cn.com/problems/plus-one
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 这中文的解释太容易误导了
 * 来回切换中英文才把题目看懂，数组每位都是single digit，所以只能是0-9的个位数，整个数没有leading zero，
 * 意思就是数组第一个数必非0，再就是要注意，像[9,9]输出就是[1,0,0]。
 * 刚开始的思路是把数组先转化成数字，加一再转化回来，自己测试也成功了，提交之后发现忽略了整型溢出的情况。
 * 后来发现用数组本身来求解更简单...
 *
 * 主要思路就是把数组倒序,然后累加,如果没等于9就直接返回结果,如果等于9了,就将当前元素赋值为0,然后继续迭代累加,如此反复
 */
public class PlusOne {

  // 自己没想出来
  static
  class Solution {
    public int[] plusOne(int[] digits) {

      return digits;
    }
  }

  // 别人的参考
  static
  class SolutionOther1 {
    public int[] plusOne(int[] digits) {
      for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] != 9) {
          digits[i]++;
          return digits;
        }
        digits[i] = 0;
      }
      //跳出for循环，说明数字全部是9
      int[] temp = new int[digits.length + 1];
      temp[0] = 1;
      return temp;
    }
  }

  // 别人的参考 取模方式
  static
  class SolutionOther2 {
    public int[] plusOne(int[] digits) {
      for (int i = digits.length - 1; i >= 0 ; i--) {
        digits[i]++;
        digits[i] = digits[i] % 10;
        if (digits[i] != 0) return digits;
      }

      digits = new int[digits.length + 1];
      digits[0] = 1;
      return digits;
    }
  }

  public static void main(String[] args) {
    SolutionOther1 solution = new SolutionOther1();

    int[][] testData = new int[][] {
      {1,2,9}
      , {0}
    };

    for (int[] data :
      testData) {
      int[] result = solution.plusOne(data);
      System.out.println(result);
    }
  }
}
