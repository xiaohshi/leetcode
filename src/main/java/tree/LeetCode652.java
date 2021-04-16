package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
652. 寻找重复的子树
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

示例 1：

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
下面是两个重复的子树：

      2
     /
    4
和

    4
因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class LeetCode652 {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, null, 2, 4, null, null, 4};
        TreeNode root = TreeUtils.generateTree(nums);

        List<TreeNode> list = findDuplicateSubtrees(root);
        for (TreeNode node : list) {
            TreeUtils.outputTree(node);
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        lookup(root);
        return ans;
    }

    private static Map<Integer, Integer> count = new HashMap<>();
    private static Map<String, Integer> trees = new HashMap<>();
    private static int t = 1;
    private static List<TreeNode> ans = new ArrayList<>();

    /*
    假设每棵子树都有一个唯一标识符：只有当两个子树的 id 相同时，认为这两个子树是相同的。

    一个节点 node 的左孩子 id 为 x，右孩子 id 为 y，那么该节点的 id 为 (node.val, x, y)。
     */
    public static int lookup(TreeNode node) {
        if (node == null) {
            return 0;
        }
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t ++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        return uid;
    }

}
