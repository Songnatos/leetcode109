class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode p, q;
        if (l1.val < l2.val) {
            p = l1;
            q = l2;
        } else {
            q = l1;
            p = l2;
        }
        ListNode head = p;

        while (q != null) {
            ListNode t = p.next;
            if (t == null) {
                p.next = q;
                break;
            }

            if (t.val <= q.val) {
                p = t;
            } else {
                ListNode r = q;
                q = q.next;
                r.next = t;
                p.next = r;
            }
        }

        return head;
    }
}
