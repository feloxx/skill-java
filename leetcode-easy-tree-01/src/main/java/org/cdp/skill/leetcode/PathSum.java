package org.cdp.skill.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112 路径总和
 * Path Sum
 * https://leetcode-cn.com/problems/path-sum
 *
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在
 * 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 * 官方思路
 * 递归思路
 * 观察要求我们完成的函数，我们可以归纳出它的功能：询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum
 * 假定从根节点到当前节点的值之和为 val，
 * 我们可以将这个大问题转化为一个小问题：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
 * 不难发现这满足递归的性质，若当前节点就是叶子节点，那么我们直接判断 sum 是否等于 val 即可（因为路径和已经确定，
 * 就是当前节点的值，我们只需要判断该路径和是否满足条件）。
 * 若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
 *
 */
public class PathSum {

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

  // 这个有点算深度遍历优先
  static
  class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
        return false;
      }
      if (root.left == null && root.right == null) {
        return targetSum == root.val;
      }
      // 一直递归到底,边递归边用targetSum 与当前节点相减
      // 如果一路递归的总和符合要求,那递归到最后一个节点的时候,减下来的结果一定与当前节点的值相等
      return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
    }
  }

  // 广度遍历,层序遍历,使用队列
  static
  class SolutionBreadth {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
        return false;
      }
      Queue<TreeNode> queNode = new LinkedList<>();
      Queue<Integer> queVal = new LinkedList<>();
      queNode.offer(root);
      queVal.offer(root.val);
      while (!queNode.isEmpty()) {
        TreeNode now = queNode.poll();
        int temp = queVal.poll();

        // 判断,出口
        if (now.left == null && now.right == null) {
          if (temp == targetSum) {
            return true;
          }
          continue;
        }

        // 遍历每层
        if (now.left != null) {
          queNode.offer(now.left);
          queVal.offer(now.left.val + temp);
        }
        if (now.right != null) {
          queNode.offer(now.right);
          queVal.offer(now.right.val + temp);
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    TreeNode test1 = new TreeNode(
      5
      , new TreeNode(4
        , new TreeNode(11
          , new TreeNode(7)
          , new TreeNode(2))
        , null)
      , new TreeNode(8
        , new TreeNode(13)
        , new TreeNode(4
          , null
          , new TreeNode(1)))
    );
    boolean result1 = new Solution().hasPathSum(test1, 22);
    System.out.println(result1);
  }
}
