class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode();
        while (head != null) {
            ListNode node = new ListNode(head.val, res.next);
            res.next = node;
            head = head.next;
        }

        return res.next;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode p = null;
        while (head != null) {
            ListNode q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode next = reverseList3(head.next);
            head.next.next = head;
            head.next = null;
            return next;
        }
    }
}
