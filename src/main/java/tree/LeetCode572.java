package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

/*
572. 另一个树的子树
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。
 */
public class LeetCode572 {

    public static void main(String[] args) {
        Integer[] nums1 = {1, null, 1, null, 1, null, 1, 2};
        Integer[] nums2 = {1, null, 1, 2};

        TreeNode s = TreeUtils.generateTree(nums1);
        TreeNode t = TreeUtils.generateTree(nums2);

        TreeUtils.outputTree(s);

        System.out.println(isSubtree(s, t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return (s != null && t != null) && (helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private static boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
