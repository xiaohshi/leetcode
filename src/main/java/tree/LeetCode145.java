package tree;

import sun.reflect.generics.tree.Tree;
import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
145. 二叉树的后序遍历(非递归) ★
使用非递归的方式进行后序遍历
 */
public class LeetCode145 {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

}
