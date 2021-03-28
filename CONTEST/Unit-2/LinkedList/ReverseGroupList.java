import java.util.Scanner;

public class ReverseGroupList {
    public static Node nextGroup = null;
    static class Node{
        int data;
        Node next;
        public Node(int d){
            this.data = d;
            next = null;
        }
    }
    private static void printList(Node head){
        while(head.next != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(head.data);
    }
    private static Node reverseUtil(Node cur,int count){
        if(cur == null)
            return cur;
        nextGroup = cur.next;
        if(cur.next == null || count == 0) {
            return cur;
        }
        Node rest = reverseUtil(cur.next, count-1);
        cur.next.next = cur;
        cur.next = null;
        return rest;
    }
    private static Node reverseGroup(Node head,int k){
        Node Last = null;
        Node mainHead = null;
        while(head != null){
            Node first = reverseUtil(head,k-1);
            printList(first);
            if(Last == null)
                mainHead = first;
            else{
                Last.next = first;
            }
            Last = head;
            head = nextGroup;
        }
        return mainHead;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Node head=null;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if(head == null)
                head = newNode;
            else
            {
                newNode.next = head;
                head = newNode;
            }
        }
        printList(head);
        /**one method to reverse in group */
        head = reverseGroup(head, k);

        /**another method to reverse in group */
        head = reverseIngroup(head, k);
        printList(head);
        sc.close();
    }
    //another method for reverse in group
    public static Node reverseIngroup(Node head,int k){
        Node cur = head,prev = null,next = null;
        int count = 0;
        while(cur != null &&  count < k){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        if(next != null)
            head.next = reverseIngroup(next, k);

        return prev;

    }
}
