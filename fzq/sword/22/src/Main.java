public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        p1.next = p2; p2.next = p3; p3.next = p4; p4.next = p5;

        System.out.println(solution.getKthFromEnd(p1, 2));
    }
}
