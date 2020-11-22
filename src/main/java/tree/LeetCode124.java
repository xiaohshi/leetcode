package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

/*
124. 二叉树中的最大路径和 ★
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1：

输入：[1,2,3]

       1
      / \
     2   3

输出：6
示例 2：

输入：[-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出：42
 */
public class LeetCode124 {

    public static void main(String[] args) {
        Integer[] nums = {-10,9,20,null,null,15,7};
        TreeNode root = TreeUtils.generateTree(nums);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private static int max = Integer.MIN_VALUE;
    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和。
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

}
