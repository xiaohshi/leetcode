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
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }

}
