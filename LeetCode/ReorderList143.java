import java.util.ArrayDeque;

public class ReorderList143 {
    public static void main(String[] args) {
        
    }   
    private static void reorderListSolWithoutSpace(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode previous = null;
        while(second != null){
            ListNode temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        }

        ListNode first = head;
        second = previous;
        while(second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            second = secondNext;
            first = firstNext;
        }
    }

    private static void reorderListSol(ListNode head){
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode currentNode = head;
        while(currentNode != null){
            deque.add(currentNode);
            currentNode = currentNode.next;
        }
        ListNode previousNode = null;
        while(!deque.isEmpty()){
            currentNode = deque.pollFirst();
            if(previousNode != null){
                previousNode.next = currentNode;
            }
            if(!deque.isEmpty()){
                ListNode lastNode = deque.pollLast();
                currentNode.next = lastNode;
            }else{
                currentNode.next = null;
                return;
            }
            previousNode = currentNode.next;
        }
        currentNode.next.next = null;
    }
}
