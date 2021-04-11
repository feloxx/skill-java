package org.cdp.skill.leetcode;

/**
 * 111 二叉树的最小深度
 * Minimum Depth of Binary Tree
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * 示例1
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * 示例2
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 思路
 * 广度优先
 * 同样，我们可以想到使用广度优先搜索的方法，遍历整棵树。
 * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。
 * 广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
 *
 * 深度优先
 * 首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。
 * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。
 * 这样就将一个大问题转化为了小问题，可以递归地解决该问题。
 *
 */
public class MinimumDepthOfBinaryTree {

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

  // 没看懂我的问题在哪 缺少的那2个逻辑没太看懂
  // static
  // class Solution {
  //   public int minDepth(TreeNode root) {
  //     if (root == null) {
  //       return 0;
  //     } else {
  //       return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  //     }
  //   }
  // }

  // 官方简单解法,但是没有剪枝,会慢一点
  static
  class Solution {
    public int minDepth(TreeNode root) {
      if (root == null) return 0;
      else if (root.left == null) return minDepth(root.right) + 1;
      else if (root.right == null) return minDepth(root.left) + 1;
      else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
  }

  public static void main(String[] args) {
    TreeNode test1 = new TreeNode(
      3
      , new TreeNode(9)
      , new TreeNode(20
        , new TreeNode(15)
        , new TreeNode(7))
    );
    int result1 = new Solution().minDepth(test1);
    System.out.println(result1);


    TreeNode test2 = new TreeNode(
      2
      , null
      , new TreeNode(3
       , null
        , new TreeNode(4
          , null
          , new TreeNode(5
            , null
            , new TreeNode(6))))
    );
    int result2 = new Solution().minDepth(test2);
    System.out.println(result2);
  }
}
