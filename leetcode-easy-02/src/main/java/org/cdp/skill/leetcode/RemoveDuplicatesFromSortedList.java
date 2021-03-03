package org.cdp.skill.leetcode;

/**
 * 83 删除排序链表中的重复元素
 * Remove Duplicates from Sorted List
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例1
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例2
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 思路
 * 官方参考
 * ListNode current = head;
 * while (current != null && current.next != null) {
 *   if (current.next.val == current.val) {
 *     current.next = current.next.next;
 *   } else {
 *     current = current.next;
 *   }
 * }
 * return head;
 */
public class RemoveDuplicatesFromSortedList {

  static
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return val + " -> " + next;
    }
  }

  static
  class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode cur = head;

      // 循环链表,如果为空则跳出
      while(cur != null && cur.next != null) {
        if (cur.val == cur.next.val) { // 链表的当前结点与下一结点判断
          cur.next = cur.next.next;    // 如果相等则把当前的指针指向下一个结点
        }
        else {                         // 为什么要加else没懂,如果不加就是每一次迭代都会进一位,那这样cur最后是会走的链表的末尾处
          cur = cur.next;              // 当前结点需要向前移动,来进行后续的迭代
        }
      }

      return cur;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode test1 = new ListNode(
      1
      , new ListNode(
      2
      , new ListNode(
      2
      , new ListNode(
      3
    ))));
    ListNode test2 = new ListNode(
      1
      , new ListNode(
      1
      , new ListNode(
      1
      , new ListNode(
      1
    ))));

    ListNode result = solution.deleteDuplicates(test2);
    System.out.println(result.toString());
  }
}
