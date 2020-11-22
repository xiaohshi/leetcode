package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

/*
687. 最长同值路径 ★
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

注意：两个节点之间的路径长度由它们之间的边数表示。

示例 1:

输入:

              5
             / \
            4   5
           / \   \
          1   1   5
输出:

2
示例 2:

输入:

              1
             / \
            4   5
           / \   \
          4   4   5
输出:

2
注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LeetCode687 {

    public static void main(String[] args) {
        Integer[] nums = {5, 4 , 5, 1, 1, null, 5};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(longestUnivaluePath(root));
    }

    public static int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }

    private static int res = 0;
    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int leftRes = 0, rightRes = 0;
        if (node.left != null && node.left.val == node.val) {
            leftRes += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightRes += right + 1;
        }
        res = Math.max(res, leftRes + rightRes);
        return Math.max(leftRes, rightRes);
    }

}
