package list;

import list.model.ListNode;
import list.utils.ListUtils;

/*
2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class LeetCode2 {

    public static void main(String[] args) {
        int[] nums1 = {4, 4, 5};
        int[] nums2 = {6, 5, 4};
        ListNode l1 = ListUtils.generateList(nums1);
        ListNode l2 = ListUtils.generateList(nums2);

        ListUtils.outputList(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res = 0, flag = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;
            res = a + b + flag;
            flag = res / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            ListNode node = new ListNode(res % 10);
            cur.next = node;
            cur = node;
        }
        if (flag == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return head.next;
    }

}
