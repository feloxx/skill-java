package org.cdp.skill.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104 二叉树的最大深度
 * Maximum Depth of Binary Tree
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * 思路
 *
 * 二叉树的遍历,一般分为两类.
 * 广度优先(层序遍历)与深度优先(前中后序遍历).
 * 那我使用深度优先去遍历,然后再把长度记录一下呢? 这个思路好像不对.
 *
 * 官方思路
 * 1.深度优先
 * 如果我们知道了左子树和右子树的最大深度 l 和 r，那么该二叉树的最大深度即为: max(l + r) + 1
 * (这个地方有个点就是,我们怎么去知道 左子树 和 右子树的最大深度呢?)
 *
 * 而左子树和右子树的最大深度又可以以同样的方式进行计算。
 * 因此我们可以用「深度优先搜索」的方法来计算二叉树的最大深度。
 * 具体而言，在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在 O(1) 时间内计算出当前二叉树的最大深度。
 * 递归在访问到空节点时退出。
 *
 *
 * 2.广度优先
 * 我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
 * 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
 * 这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，
 * 最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans。
 */
public class MaximumDepthOfBinaryTree {

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

  // 深度优先
  static
  class Solution {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      } else {
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return Math.max(leftHight, rightHight) + 1; // l r 最深层的时候都是0,然后使用辅助+1 逐层上升, 因为有左右子树之分,所以需要左右比较
      }
    }
  }

  // 广度优先
  static
  class SolutionBreadth {
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int ans = 0; // 记录深度
      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size > 0) { // 进行树的每一层遍历,队列里每次正好都是放的这一层的数据
          // 进行这一层的遍历
          TreeNode node = queue.poll();
          // 把这一层叶子节点放进队列
          if (node.left != null) { queue.offer(node.left); }
          if (node.right != null) { queue.offer(node.right); }
          size--;
        }
        ans++; // 这一层遍历完,记数+1
      }
      return ans;
    }
  }

  public static void main(String[] args) {
    TreeNode test1 = new TreeNode(
      3
      , new TreeNode(9
        , new TreeNode(3)
        , new TreeNode(4))
      , new TreeNode(20
        , new TreeNode(15)
        , new TreeNode(7)
      )
    );

    System.out.println(new Solution().maxDepth(test1));

    System.out.println(new SolutionBreadth().maxDepth(test1));
  }
}
