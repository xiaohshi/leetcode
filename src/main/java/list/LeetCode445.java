package list;

import list.model.ListNode;
import list.utils.ListUtils;

import java.util.Stack;

/*
445. 两数相加 II
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。



进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。



示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class LeetCode445 {

    public static void main(String[] args) {
        int[] nums1 = {9, 9, 9};
        int[] nums2 = {1};
        ListNode l1 = ListUtils.generateList(nums1);
        ListNode l2 = ListUtils.generateList(nums2);

        ListUtils.outputList(addTwoNumbers(l1, l2));

    }

    // 利用栈，遇到逆序处理问题，一定要想到栈
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int res = 0, flag = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = !stack1.isEmpty() ? stack1.pop() : 0;
            int b = !stack2.isEmpty() ? stack2.pop() : 0;
            res = a + b + flag;
            flag = res / 10;
            ListNode node = new ListNode(res % 10);
            node.next = cur;
            cur = node;
        }
        if (flag == 1) {
            ListNode node = new ListNode(1);
            node.next = cur;
            cur = node;
        }
        return cur;
    }

}
