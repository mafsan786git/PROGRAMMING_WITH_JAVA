import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // ListNode secondNode = new ListNode(2);
        // head.next = secondNode;
        head = removeNthFromEndWithTwoPointer(head, 1);
        System.out.println(head);
    }

    public static ListNode removeNthFromEndUsingMap(ListNode head, int n) {
        Map<Integer,ListNode> nodeMap = new HashMap<>();
        ListNode answer = head;
        ListNode previous = null;
        int count = 0;
        while(head != null){
            count++;
            nodeMap.put(count,previous);
            previous = head;
            head = head.next;
        }
        if(count == n){
            answer = answer.next;
        }else{
            previous = nodeMap.get(count-n+1);
            previous.next = previous.next.next;
        }
        return answer;
   }

   public static ListNode removeNthFromEndWithTwoPointer(ListNode head, int n) {
    ListNode answer = head;
    ListNode removeFirstN = head;
    for(int i=0;i<n;i++){
        removeFirstN = removeFirstN.next;
    }
    if(removeFirstN == null) return head.next;
    while(removeFirstN != null){
        removeFirstN = removeFirstN.next;
        answer = answer.next;
    }
    answer.next = answer.next.next;
    return head;
}
}
