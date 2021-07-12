public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l21.next = l22;
        l22.next = l23;

        System.out.println(solution.mergeTwoLists(l11, l21));
    }
}
