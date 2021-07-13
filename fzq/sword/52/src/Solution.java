class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int count = 2;
        while (count > 0) {
            if (p == q)
                return p;

            if (p == null) {
                count--;
                p = headB;
            } else {
                p = p.next;
            }
            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return null;
    }
}
