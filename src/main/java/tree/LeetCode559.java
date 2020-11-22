package tree;

import java.util.ArrayList;
import java.util.List;

/*
559. N叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

例如，给定一个 3叉树 :

我们应返回其最大深度，3。

说明:

树的深度不会超过 1000。
树的节点总不会超过 5000。
 */
public class LeetCode559 {

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<>());
        Node node1 = new Node(3, new ArrayList<>());

        root.children.add(node1);
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));

        node1.children.add(new Node(5, new ArrayList<>()));
        node1.children.add(new Node(6, new ArrayList<>()));

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 1);
    }

    private static int helper(Node node, int depth) {
        if (node == null || node.children.isEmpty()) {
            return depth;
        }
        int max = 0;
        for (Node child : node.children) {
            max = Math.max(helper(child, depth + 1), max);
        }
        return max;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
