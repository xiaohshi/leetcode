package tree.util;

import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    // 根据数组生成二叉树，该数组必须是层次遍历的数组
    public static TreeNode generateTree(Integer[] nums) {
        int i = 1, n = nums.length;
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < n && nums[i] != null) {
                node.left  = new TreeNode(nums[i]);
                queue.offer(node.left);
            }
            i ++;
            if (i < n && nums[i] != null) {
                node.right = new TreeNode(nums[i]);
                queue.offer(node.right);
            }
            i ++;
        }
        return root;
    }

    // 输出树，层次输出
    public static void outputTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
                continue;
            }
            list.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer a : list) {
            sb.append(a).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        System.out.println(sb);
    }

}
