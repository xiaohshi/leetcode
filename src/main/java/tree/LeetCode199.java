package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/*
199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class LeetCode199 {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5, null, 4};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        helper(root, 1);
        return res;
    }

    private static int curDepth = 0;
    private static List<Integer> res = new ArrayList<>();
    private static void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > curDepth) {
            curDepth = depth;
            res.add(node.val);
        }
        helper(node.right, depth + 1);
        helper(node.left, depth + 1);
    }

}
