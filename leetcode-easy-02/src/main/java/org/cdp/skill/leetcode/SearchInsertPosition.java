package org.cdp.skill.leetcode;


/**
 * 35 搜索插入位置
 * Search Insert Position
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 为什么题解是会跟二分查找联系起来的呢?
 *
 * 官方题解
 * 假设题意是叫你在排序数组中寻找是否存在一个目标值，那么训练有素的读者肯定立马就能想到利用二分法在 O(logn) 的时间内找到是否存在目标值。
 * 但这题还多了个额外的条件，即如果不存在数组中的时候需要返回按顺序插入的位置，那我们还能用二分法么？答案是可以的，我们只需要稍作修改即可。
 */
public class SearchInsertPosition {

  // static
  // class Solution {
  //   public int searchInsert(int[] nums, int target) {
  //     int result = 0;
  //     for (int i = 0; i < nums.length; ++i) {
  //       if (nums[i] <= target) {
  //         result = i;
  //       }
  //       if (nums[i] > target) {
  //         result = i;
  //       }
  //     }
  //     return result;
  //   }
  // }

  static
  class Solution {
    public int searchInsert(int[] nums, int target) {
      int left = 0, right = nums.length - 1;
      while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] == target) {
          return mid;
        } else if(nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return left;
    }
  }



  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] test1 = new int[]{1,3,5,6};
    int test2 = 5;
    int test3 = 2;

    int result = solution.searchInsert(test1, test3);
    System.out.println(result);
  }
}
