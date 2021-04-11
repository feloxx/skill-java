package org.cdp.skill.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101 对称二叉树
 * Symmetric Tree
 * https://leetcode-cn.com/problems/symmetric-tree
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 思路
 *
 * 递归
 * 它们的两个根结点具有相同的值
 * 每个树的右子树都与另一个树的左子树镜像对称
 * 我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，pp 指针和 qq 指针一开始都指向这棵树的根，
 * 随后 pp 右移时，qq 左移，pp 左移时，qq 右移。每次检查当前 pp 和 qq 节点的值是否相等，如果相等再判断左右子树是否对称。
 *
 *
 * 迭代
 */
public class SymmetricTree {

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

  // 自己想的,想用层序遍历,也叫迭代法
  // 但是卡在比较的部分,没有想出来
  static
  class Solution {
    public boolean isSymmetric(TreeNode root) {
      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) {
          return true;
        }
        if (node.left == null || node.right == null) {
          return false;
        }
        if ((node.left.val != node.right.val)
          && (Math.abs(node.left.val - node.right.val) != 1)) {
          return false;
        }
        queue.offer(node.left);
        queue.offer(node.right);
      }
      return true;
    }
  }

  // 官方递归方法
  static
  class SolutionRecursion {
    public boolean isSymmetric(TreeNode root) {
      return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      }
      if (p == null || q == null) {
        return false;
      }
      // 没想明白为什么要 递归2次
      return p.val == q.val
        && check(p.left, q.right)
        && check(p.right, q.left);
    }
  }

  // 官方迭代方法
  static
  class SolutionIteration {
    public boolean isSymmetric(TreeNode root) {
      TreeNode u = root;
      TreeNode v = root;

      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(u);
      q.offer(v);
      while (!q.isEmpty()) {
        u = q.poll();
        v = q.poll();
        if (u == null && v == null) {
          continue;
        }
        if ((u == null || v == null) || (u.val != v.val)) {
          return false;
        }
        q.offer(u.left);
        q.offer(v.right);

        q.offer(u.right);
        q.offer(v.left);
      }
      return true;
    }
  }

  public static void main(String[] args) {
    TreeNode test1 = new TreeNode(
      1
      ,new TreeNode(2
        , new TreeNode(4)
        , new TreeNode(3))
      ,new TreeNode(2
        , new TreeNode(3)
        , new TreeNode(4))
    );

    TreeNode test2 = new TreeNode(
      1
      , new TreeNode(2
        , null
        , new TreeNode(3))
      , new TreeNode(2
        , null
        , new TreeNode(3))
    );

    TreeNode test3 = new TreeNode(
      1
      , new TreeNode(2)
      , new TreeNode(3)
    );

    boolean result1 = new Solution().isSymmetric(test1);
    System.out.println(result1);

    boolean result2 = new Solution().isSymmetric(test2);
    System.out.println(result2);
  }
}
