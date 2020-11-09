package list;

import list.model.ListNode;
import list.utils.ListUtils;

/*
21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class LeetCode21 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode l1 = ListUtils.generateList(nums1);
        ListNode l2 = ListUtils.generateList(nums2);

        ListUtils.outputList(mergeTwoLists(l1, l2));
        // 把其变成一个链表了，因此会出现死循环
        // 改进就是将以上链表重新复制一遍
        ListUtils.outputList(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

}
