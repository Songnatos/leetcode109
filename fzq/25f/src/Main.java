public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode n1, n2 ,n3, n4, n5;
        n5 = new ListNode(5, null);
        n4 = new ListNode(4, n5);
        n3 = new ListNode(3, n4);
        n2 = new ListNode(2, n3);
        n1 = new ListNode(1, n2);

        System.out.println(solution.reverseKGroup(n1, 2));
    }
}
