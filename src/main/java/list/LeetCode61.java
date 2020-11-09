package list;

import list.model.ListNode;
import list.utils.ListUtils;

/*
61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */
public class LeetCode61 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListUtils.generateList(nums);

        ListUtils.outputList(rotateRight(head, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head, tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n ++;
        }
        int m = k % n, t = n - m;
        if (m == 0) {
            return head;
        }
        ListNode pre = null;
        for (int i = 0; i < t; i ++) {
            pre = cur;
            cur = cur.next;
        }
        tail.next = head;
        pre.next = null;
        return cur;
    }

}
