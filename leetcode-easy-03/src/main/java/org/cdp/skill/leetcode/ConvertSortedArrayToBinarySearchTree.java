package org.cdp.skill.leetcode;

/**
 * 108 将有序数组转换为二叉搜索树
 * Convert Sorted Array to Binary Search Tree
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 *
 *      0
 *     / \
 *   -10  5
 *     \   \
 *     -3   9
 *
 *
 * 官方思路
 * 二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列。
 * 给定二叉搜索树的中序遍历，是否可以唯一地确定二叉搜索树？答案是否定的。
 * 如果没有要求二叉搜索树的高度平衡，则任何一个数字都可以作为二叉搜索树的根节点，因此可能的二叉搜索树有多个。
 * 直观地看，我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 1，可以使得树保持平衡。
 * 如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点，
 * 选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。
 *
 * 核心就是 选这个有序数组的中心点,作为二叉搜索树的根节点
 *
 * 确定平衡二叉搜索树的根节点之后，其余的数字分别位于平衡二叉搜索树的左子树和右子树中，左子树和右子树分别也是平衡二叉搜索树，因此可以通过递归的方式创建平衡二叉搜索树。
 *
 * 方法一：中序遍历，总是选择中间位置左边的数字作为根节点
 * 选择中间位置左边的数字作为根节点，则根节点的下标为 mid = (left + right)/2，此处的除法为整数除法。
 *
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

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

    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }

  static
  class SolutionMid {
    public TreeNode sortedArrayToBST(int[] nums) {
      return tailrec(nums, 0, nums.length - 1);
    }

    private TreeNode tailrec(int[] nums, int left, int right) {
      if (left > right) return null;

      // 选择中间节点做为根节点
      int mid = (left + right) / 2;

      TreeNode root = new TreeNode(nums[mid]);
      // 注意这里递归传递的是数组的下标
      // 左子树传入 最左边的下标和中间下标
      // 右子树传入 中间下标和最右边的的下标
      // 递归的时候会去变动下标,将下标对应的值添加到树中
      root.left = tailrec(nums, left, mid - 1);
      root.right = tailrec(nums, mid + 1, right);

      return root;
    }
  }

  public static void main(String[] args) {
    int[] test1 = new int[]{-10,-3,0,5,9};
    TreeNode result1 = new SolutionMid().sortedArrayToBST(test1);
    System.out.println(result1.toString());
  }
}
