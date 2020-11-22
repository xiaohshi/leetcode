package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/*
437. 路径总和 III ★
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
 */
public class LeetCode437 {

    public static void main(String[] args) {
        Integer[] nums = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(pathSum(root, 8));
        TreeUtils.outputTree(root);
    }

    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(map, root, 0, sum);
        return res;
    }

    /*
    利用前缀和的思想，先记录到某一段的和为curSum1, 并继续dfs深度搜索，此时如果在某一个位置的时候curSum2 - curSum1 = target
    就说明有一段路径和就是target。
     */
    private static int res = 0;
    private static void helper(Map<Integer, Integer> map, TreeNode node, int curSum, int target) {
        if (node == null) {
            return;
        }
        curSum += node.val;
        res += map.getOrDefault(curSum - target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        helper(map, node.left, curSum, target);
        helper(map, node.right, curSum, target);

        map.put(curSum, map.get(curSum) - 1);
    }

}
