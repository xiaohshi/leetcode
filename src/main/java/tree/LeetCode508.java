package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.*;

/*
508. 出现次数最多的子树元素和
给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。

你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。

示例 1：
输入:

  5
 /  \
2   -3
返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。

示例 2：
输入：

  5
 /  \
2   -5
返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 */
public class LeetCode508 {

    public static void main(String[] args) {

        Integer[] nums = {5, 2, -3};

        TreeNode root = TreeUtils.generateTree(nums);

        for (int num : findFrequentTreeSum(root)) {
            System.out.print(num + " ");
        }
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        heler(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int max = 0;
    private static int heler(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = heler(node.left);
        int right = heler(node.right);
        int sum = left + right + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }

}
