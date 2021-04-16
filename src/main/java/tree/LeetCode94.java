package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94. 二叉树的中序遍历（非递归）★
给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class LeetCode94 {

    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 3};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
