package org.cdp.skill.leetcode;

import java.util.Arrays;

/**
 * 88 合并两个有序数组
 * Merge Sorted Array
 * https://leetcode-cn.com/problems/merge-sorted-array
 *
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例1
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例2
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 思路
 * 官方思路
 * 将两个数组合并,再排序
 * 该算法只需要一行(Java是2行)，时间复杂度较差，为O((n + m)log(n + m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
 *
 *
 * 双指针思路 从前往后
 * 一般而言，对于有序数组可以通过 双指针法 达到O(n+m)的时间复杂度。
 * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
 * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m) 的空间复杂度。
 *
 * 双指针思路 从后往前
 * 方法二已经取得了最优的时间复杂度O(n + m)，但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。
 * 相当于nums1的前面已经是排序好的了, 这样可以节省更多的空间
 */
public class MergeSortedArray {

  // 使用内置包,合并后排序
  static
  class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      System.arraycopy(nums2, 0, nums1, m, n);
      Arrays.sort(nums1);

      System.out.println(Arrays.toString(nums1));
    }
  }

  // 双指针 从前往后 没理解
  static
  class SolutionDoublePointer {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      // Make a copy of nums1.
      int[] nums1_copy = new int[m];
      System.arraycopy(nums1, 0, nums1_copy, 0, m);

      // Two get pointers for nums1_copy and nums2.
      int p1 = 0;
      int p2 = 0;

      // Set pointer for nums1
      int p = 0;

      // Compare elements from nums1_copy and nums2
      // and add the smallest one into nums1.
      while ((p1 < m) && (p2 < n))
        nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

      // if there are still elements to add
      if (p1 < m)
        System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
      if (p2 < n)
        System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
  }

  // 双指针 从后往前 没理解
  static
  class SolutionDoublePointerAfter {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      // two get pointers for nums1 and nums2
      int p1 = m - 1;
      int p2 = n - 1;
      // set pointer for nums1
      int p = m + n - 1;

      // while there are still elements to compare
      while ((p1 >= 0) && (p2 >= 0))
        // compare two elements from nums1 and nums2
        // and add the largest one in nums1
        nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

      // add missing elements from nums2
      System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] test1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] test2 = new int[]{2, 5, 6};

    solution.merge(test1, 3, test2, 2);
  }
}
