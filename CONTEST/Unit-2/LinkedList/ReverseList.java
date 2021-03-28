import java.util.Scanner;

public class ReverseList {
    private static Node last = null;
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
    private static Node reverseList(Node head){
        Node prev,cur,next;
        prev = null;next = null;
        cur = head;
        while(cur.next != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }

    private static Node reverseListRecursiveVers1(Node cur,Node prev){
        if(cur == null)
            return cur;
        if(cur.next == null){
            last = cur;
            cur.next = prev;
            return last;
        }

        Node next = cur.next;
        cur.next = prev;
        reverseListRecursiveVers1(next, cur);
        return last;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
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
        head = reverseList(head);
        printList(head);
        head = reverseListRecursiveVers1(head, null);
        printList(head);
        sc.close();
    }
}
