package list;

import list.model.ListNode;
import list.utils.ListUtils;

/*
23. 合并K个升序链表 ★
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */
public class LeetCode23 {

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode[] lists = {ListUtils.generateList(nums1)
                , ListUtils.generateList(nums2)
                , ListUtils.generateList(nums3)};
        ListUtils.outputList(mergeKLists(lists));
    }

    // 两两合并
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private static ListNode merge(ListNode[] lists, int l, int r) {
        if (lists.length == 0) {
            return null;
        }
        if (l >= r) {
            return lists[l];
        }
        int m = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, m), merge(lists, m + 1, r));
    }

    private static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }
        if (a != null) {
            node.next = a;
        }
        if (b != null) {
            node.next = b;
        }
        return head.next;
    }

}
