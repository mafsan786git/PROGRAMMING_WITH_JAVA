public class ListNode{
    int val;
    ListNode left;
    ListNode right;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode left, ListNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
