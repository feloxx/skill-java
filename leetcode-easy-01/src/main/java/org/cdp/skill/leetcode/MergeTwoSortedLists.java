package org.cdp.skill.leetcode;

import java.util.List;

/**
 * 21 合并两个有序链表
 * Merge Two Sorted Lists
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 思路
 * 标签：链表、递归
 * 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
 * 意思不需要构建新的链表去装结果,因为2个链表已经排好序了只需交叉合并成一个即可,主要还是考递归
 * 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
 * 返回值：每一层调用都返回排序好的链表头
 * 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
 * O(m+n)O(m+n)，mm 为 l1的长度，nn 为 l2 的长度
 */
public class MergeTwoSortedLists {

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
      return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
    }
  }

  static
  class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;

      if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
      } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode test2 = new ListNode(1, new ListNode(3, new ListNode(4)));

    ListNode result = solution.mergeTwoLists(test1, test2);

    System.out.println(result.toString());
  }
}
