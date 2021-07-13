class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(head.val);
        while (head != null) {
            ListNode p = head;
            head = head.next;
            ListNode t = new ListNode(p.val);
            t.next = res.next;
            res.next = t;
        }
        return res.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode p = null, q = head, s;
        while (q != null) {
            s = q.next;
            q.next = p;
            p = q;
            q = s;
        }
        return p;
    }

}
