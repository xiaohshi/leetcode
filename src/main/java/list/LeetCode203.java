package list;

import list.model.ListNode;
import list.utils.ListUtils;

import java.util.List;

/*
203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class LeetCode203 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        ListNode head = ListUtils.generateList(nums);

        ListUtils.outputList(removeElements(head, 1));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;
        while (head != null) {
            if (head.val == val) {
                temp.next = head.next;
            } else {
                temp = head;
            }
            head = head.next;
        }
        return node.next;
    }

}
