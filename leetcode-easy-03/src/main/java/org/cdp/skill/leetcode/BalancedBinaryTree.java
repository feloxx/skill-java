package org.cdp.skill.leetcode;

/**
 * 101 平衡二叉树
 * Balanced Binary Tree
 * https://leetcode-cn.com/problems/balanced-binary-tree
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例1
 *
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例2
 *          1
 *         / \
 *        2   2
 *       / \
 *      3   3
 *     / \
 *    4   4
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例3
 * 输入：root = []
 * 输出：true
 *
 *
 * 思路
 * 这道题中的平衡二叉树的定义是：二叉树的每个节点的左右子树的高度差的绝对值不超过 1，则二叉树是平衡二叉树。
 * 根据定义，一棵二叉树是平衡二叉树，当且仅当其所有子树也都是平衡二叉树，因此可以使用递归的方式判断二叉树是不是平衡二叉树，递归的顺序可以是自顶向下或者自底向上。
 *
 * 怎么递归判断呢?
 *
 * 方法一：自顶向下的递归
 * 这是一个计算公式
 * height(p)
 * p 是空节点 = 0
 * p 是非空节点 = max(height(p.left), height(p.right)) + 1
 *
 * 有了计算节点高度的函数，即可判断二叉树是否平衡。
 * 具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，首先计算左右子树的高度，如果左右子树的高度差是否不超过 1，
 * 再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。这是一个自顶向下的递归的过程。
 *
 * 方法二: 自底向上的递归
 * 方法一由于是自顶向下递归，因此对于同一个节点，函数 height 会被重复调用，导致时间复杂度较高。
 * 如果使用自底向上的做法，则对于每个节点，函数 height 只会被调用一次。
 * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。
 * 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
 *
 * 总结,最后思路都是拿到高度,然后计算高度
 * 如果高度不符合平衡,则返回错误
 */
public class BalancedBinaryTree {

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

  // 自顶向下, 也比较符合正常思路的想法
  static
  class Solution {
    public boolean isBalanced(TreeNode root) {
      if (root == null) {
        return true;
      } else {
        // 比较左右子树的高度
        // 传入左右子树进入递归
        return Math.abs(height(root.left) - height(root.right)) <= 1
          && isBalanced(root.left)
          && isBalanced(root.right);
      }
    }

    // 计算树的高度
    private int height(TreeNode root) {
      // 递归的出口,切记
      if (root == null) {
        return 0;
      } else {
        return Math.max(
          height(root.left)
          , height(root.right)
        ) + 1;
      }
    }
  }

  // 自低向上, 这个太好理解了
  static
  class SolutionReverse {
    public boolean isBalanced(TreeNode root) {
      return height(root) >= 0;
    }

    public int height(TreeNode root) {
      if (root == null) {
        return 0;
      }

      int leftHeight = height(root.left);
      int rightHeight = height(root.right);
      if (leftHeight == -1 || rightHeight == -1
        || Math.abs(leftHeight - rightHeight) > 1) {
        return -1;
      } else {
        return Math.max(leftHeight, rightHeight) + 1;
      }
    }
  }

  // 另一个 如果左子树已经返回-1了就不需要再递归右子树了，直接返回-1就可以了
  static
  class SolutionReverse2 {
    public boolean isBalanced(TreeNode root) {
      return balanced(root) != -1;
    }

    private int balanced(TreeNode node) {
      if (node == null) return 0;
      int leftHeight, rightHeight;
      if ((leftHeight = balanced(node.left)) == -1
        || (rightHeight = balanced(node.right)) == -1
        || Math.abs(leftHeight - rightHeight) > 1)
        return -1;
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  public static void main(String[] args) {
    TreeNode test1 = new TreeNode(
      3
      , new TreeNode(9)
      , new TreeNode(20
        , new TreeNode(15)
        // , new TreeNode(7)
        , null
        )
    );

    boolean result1 = new Solution().isBalanced(test1);
    System.out.println(result1);
  }
}
