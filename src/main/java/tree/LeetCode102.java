package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class LeetCode102 {

    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, TreeNode node, int i) {
        if (node == null) {
            return;
        }
        if (i >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(i).add(node.val);
        helper(res, node.left, i + 1);
        helper(res, node.right, i + 1);
    }

}
