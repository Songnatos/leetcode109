class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode p, q, res, t;
        if (l1.val <= l2.val) {
            p = l1;
            q = l2;
        } else {
            p = l2;
            q = l1;
        }
        res = p;

        while (q != null) {
            if (p.next == null) {
                p.next = q;
                break;
            } else if (q.val <= p.next.val) {
                t = q;
                q = q.next;
                t.next = p.next;
                p.next = t;
            }
            p = p.next;
        }

        return res;
    }
}
