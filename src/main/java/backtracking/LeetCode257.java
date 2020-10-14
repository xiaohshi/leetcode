package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class LeetCode257 {

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a5 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.right = a5;

        System.out.println(binaryTreePaths(a1));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root, new ArrayList<>());
        return res;
    }

    public static void helper(List<String> res, TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i ++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append("->");
                }
            }
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
        } else {
            helper(res, node.left, list);
            helper(res, node.right, list);
        }
        list.remove(list.size() - 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
