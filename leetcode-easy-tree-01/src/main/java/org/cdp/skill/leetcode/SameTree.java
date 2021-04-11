package org.cdp.skill.leetcode;

import java.util.ArrayList;

/**
 * 100 相同的树
 * Same Tree
 * https://leetcode-cn.com/problems/same-tree
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * 思路
 * 自己想的,看题目的示例会自觉的往左序遍历方面靠,然后将遍历完的结果放到一个数组里,最后再比对两个数组即可
 *
 * 官方深度优先,应该也算左中右序中的一种,只是遍历树的时候就直接比对结果了,因为只有一个不相等就可以返回false,剩下的可以继续递归下去
 * 时间复杂度：O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
 * 空间复杂度：O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数
 *
 * 广度优先搜索,这个就太难了,后续再说
 */
public class SameTree {

  static
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // 自己想的
  static
  class Solution {
    ArrayList<Object> tree1 = new ArrayList<>();
    ArrayList<Object> tree2 = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
      orderTravers(p, tree1);
      orderTravers(q, tree2);
      System.out.println(tree1);
      System.out.println(tree2);
      return tree1.equals(tree2);
    }

    private void orderTravers(TreeNode root, ArrayList<Object> carrier) {
      if (root != null) {
        carrier.add(root.val);
        orderTravers(root.left, carrier);
        orderTravers(root.right, carrier);
      } else {
        carrier.add(null);
      }
    }
  }

  // 官方题解
  // 深度优先遍历
  static
  class SolutionDirect {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      } else if (p == null || q == null) {
        return false;
      } else if (p.val != q.val) {
        return false;
      } else {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.left);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode test11 = new TreeNode(
      1
      , new TreeNode(2)
      , new TreeNode(3)
    );

    TreeNode test12 = new TreeNode(
      1
      , new TreeNode(2)
      , new TreeNode(3)
    );

    TreeNode test21 = new TreeNode(
      1
      , new TreeNode(2)
      , null
    );
    TreeNode test22 = new TreeNode(
      1
      , null
      , new TreeNode(2)
    );

    boolean result1 = new Solution().isSameTree(test11, test12);
    System.out.println(result1);

    boolean result2 = new Solution().isSameTree(test21, test22);
    System.out.println(result2);

    boolean result3 = new SolutionDirect().isSameTree(test21, test22);
    System.out.println(result3);
  }
}
