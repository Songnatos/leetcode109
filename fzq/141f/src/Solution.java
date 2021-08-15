class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p = head, q = head.next;
        while (q != null) {
            if (p == q)
                return true;
            p = p.next;
            q = q.next;
            if (q != null)
                q = q.next;
        }
        return false;
    }
}
