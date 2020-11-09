package list;

import list.model.ListNode;
import list.utils.ListUtils;

/*
92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
public class LeetCode92 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListUtils.generateList(nums);

        ListUtils.outputList(reverseBetween(head, 1, 2));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prefix = new ListNode(0);
        prefix.next = head;
        ListNode pre = prefix;
        for (int i = 1; i < m; i ++) {
            pre = head;
            head = head.next;
        }
        ListNode cur = head, temp, tmp = null;
        for (int i = m; i <= n; i ++) {
            temp = cur.next;
            cur.next = tmp;
            tmp = cur;
            cur = temp;
        }
        pre.next = tmp;
        head.next = cur;
        return prefix.next;
    }

}
