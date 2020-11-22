package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/*
513. 找树左下角的值 ★
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:

输入:

    2
   / \
  1   3

输出:
1


示例 2:

输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7


注意: 您可以假设树（即给定的根节点）不为 NULL。
 */
public class Leetcode513 {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, null, 5, 6, null, null, 7};
        TreeNode root = TreeUtils.generateTree(nums);

        System.out.println(findBottomLeftValue(root));
        System.out.println(findBottomLeftValue1(root));
    }

    // 利用层次遍历
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0, res = 0;
        while (!queue.isEmpty()) {
            sum = queue.size();
            while (sum -- > 0) {
                TreeNode node = queue.poll();
                if (sum == 0) {
                    res = node.val;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }

    // 利用递归
    public static int findBottomLeftValue1(TreeNode root) {
        helper(root, 1);
        return res;
    }

    private static int res = 0, curDepth = 0;
    private static void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && depth > curDepth) {
            curDepth = depth;
            res = node.val;
        }
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }

}
