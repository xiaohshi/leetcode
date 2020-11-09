package list;

import list.model.ListNode;
import list.utils.ListUtils;

/*
25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。



示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5



说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class LeetCode25 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListUtils.generateList(nums);

        ListUtils.outputList(reverseKGroup(head, 2));
    }

    // 部分翻转，两次遍历
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        int n = len / k;

        ListNode prefix = new ListNode(0);
        prefix.next = head;
        cur = head;
        ListNode pre = prefix, temp, tmp = null;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < k; j ++) {
                temp = cur.next;
                cur.next = tmp;
                tmp = cur;
                cur = temp;
            }
            pre.next = tmp;
            head.next = cur;
            pre = head;
            head = cur;
            tmp = null;
        }
        return prefix.next;
    }

}
