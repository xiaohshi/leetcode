package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

/*
617. 合并二叉树 ★
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:

输入:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
输出:
合并后的树:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
注意: 合并必须从两个树的根节点开始。
 */
public class LeetCode617 {

    public static void main(String[] args) {
        Integer[] nums1 = {1,3,2,5};
        Integer[] nums2 = {2,1,3,null,4,null,7};

        TreeNode t1 = TreeUtils.generateTree(nums1);
        TreeNode t2 = TreeUtils.generateTree(nums2);

        TreeUtils.outputTree(mergeTrees(t1, t2));
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
