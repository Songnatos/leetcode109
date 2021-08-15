import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p, q, r = new ListNode(), s;
        p = q = head;

        for (int i = 0; i < k-1; i++) {
            if (head != null)
                head = head.next;
        }
        if (head == null) {
            return p;
        }

        Deque<ListNode> stack = new LinkedList<>();

        while (true) {
            int t = k;
            while (q != null && t-- > 0) {
                q = q.next;
            }
            if (t > 0) {
                break;
            }
            while (p != q) {
                stack.push(p);
                p = p.next;
            }
            while (!stack.isEmpty()) {
                s = stack.pop();
                r.next = s;
                r = s;
            }
            r.next = p;
        }
        return head;
    }
}
