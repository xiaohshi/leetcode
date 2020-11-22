package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

/*
543. 二叉树的直径 ★
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class LeetCode543 {

    public static void main(String[] args) {
        Integer[] nums = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(diameterOfBinaryTree(root));

        TreeUtils.outputTree(root);

        System.out.println(helper(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private static int max = 0;
    // 自底向上的进行高度累加
    private static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

}
