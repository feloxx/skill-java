package org.cdp.skill.leetcode;

import java.util.HashMap;

/**
 * 13 罗马数字转整数
 * Roman to Integer
 * https://leetcode-cn.com/problems/roman-to-integer
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 */
public class RomanToInteger {

  static
  class Solution {
    public int romanToInt(String s) {
      if(s == null || s.equals("")){
        return 0;
      }
      HashMap<Character,Integer> map = new HashMap<>();
      map.put('I',1);
      map.put('V',5);
      map.put('X',10);
      map.put('L',50);
      map.put('C',100);
      map.put('D',500);
      map.put('M',1000);

      int sum = 0;

      char[] array = s.toCharArray();
      for(int i = 0; i < array.length ; i++){
        Integer value = map.get(array[i]);
        if(i == array.length - 1){
          sum += value;
          continue;
        }
        Integer nextValue = map.get(array[i + 1]);
        if(nextValue <= value){
          sum += value;
        }else{
          sum -= value;
        }
      }

      return sum;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String test1 = "III";
    String test2 = "LVIII";

    System.out.println(solution.romanToInt(test1));
    System.out.println(solution.romanToInt(test2));
  }
}
