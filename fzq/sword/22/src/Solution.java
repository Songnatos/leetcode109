class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head;
        while (q != null) {
            while (k > 0) {
                q = q.next;
                k--;
            }
            if (q == null)
                break;
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
