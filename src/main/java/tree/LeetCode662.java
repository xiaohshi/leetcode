package tree;

import tree.model.TreeNode;
import tree.util.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

/*
662. 二叉树最大宽度 ★
给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入:

           1
         /   \
        3     2
       / \     \
      5   3     9

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:

输入:

          1
         /
        3
       / \
      5   3

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
示例 3:

输入:

          1
         / \
        3   2
       /
      5

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
示例 4:

输入:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 */
public class LeetCode662 {

    public static void main(String[] args) {
        Integer[] nums = {1, 3, 2, 5};
        TreeNode root = TreeUtils.generateTree(nums);
        System.out.println(widthOfBinaryTree(root));
    }

    /*
    思路：
    题目中定义的宽度，刚好对应完全二叉树的特性，每一层的层宽，等于完全二叉树中对应节点的编号差，以题目中的 case 作为示例
        1
       / \
      3   2
     / \   \
    5   3   9
    节点在满二叉树中的编号值
        0
       / \
      1   2
     / \   \
    3   4   6
   很明显 层宽 = 每一层的最右侧编号 - 最左侧编号 + 1

   主要思路是，直接原地修改节点的 val 用来存储满二叉树中的编号
    */
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        int sum, ans = 0;
        while (!queue.isEmpty()) {
            sum = queue.size();
            ans = Math.max(ans, queue.getLast().val - queue.getFirst().val + 1);
            while (sum > 0) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    temp.left.val = temp.val * 2 + 1;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    temp.right.val = temp.val * 2 + 2;
                }
                sum --;
            }
        }
        return ans;
    }

}
