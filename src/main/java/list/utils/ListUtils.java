package list.utils;

import list.model.ListNode;

public class ListUtils {

    public static ListNode generateList(int[] nums) {
        ListNode head = new ListNode(0), temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return head.next;
    }

    public static void outputList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
