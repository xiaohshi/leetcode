package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
144. 二叉树的前序遍历（非递归） ★
使用非递归的方式进行前序遍历
 */
public class LeetCode144 {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeUtils.generateTree(nums);

        System.out.println(preorderTraversal(root));
    }

    // 利用栈的思想，前序遍历是：中左右的思想
    public static List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 先判断栈是否为空，或者节点是否为空
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                // 先输出
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
