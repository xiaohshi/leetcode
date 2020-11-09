package list;


import list.model.ListNode;
import list.utils.ListUtils;

/*
206. 反转链表

利用递归版本

反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class LeetCode206 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListUtils.generateList(nums);

        ListUtils.outputList(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
