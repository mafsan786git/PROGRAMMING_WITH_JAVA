public class AddTwoNumber2 {

    public static void main(String[] args) {
        ListNode l1 = createLinkList(new int[]{2,4,3});
        ListNode l2 = createLinkList(new int[]{5,6,4});
        ListNode answer = addTwoNumbers(l1,l2);
        while(answer != null){
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode root = answer;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int number1 = (l1 != null) ? l1.val : 0;
            int number2 = (l2 != null) ? l2.val : 0;
            int sum = number1 + number2 + carry;
            carry = sum/10;
            ListNode temp = new ListNode(sum%10);
            root.next = temp;
            root = root.next;
            l1 = (l1 != null ) ? l1.next : null;
            l2 = (l2 != null ) ? l2.next : null;
        }
        ListNode result = answer.next;
        answer.next = null;
        return result;

    }

    public static ListNode createLinkList(int[] arr){
        ListNode answer = new ListNode(arr[0]);
        ListNode root = answer;
        for (int j = 1; j < arr.length; j++) {
            ListNode temp = new ListNode(arr[j]);
            answer.next = temp;
            answer = answer.next;
            answer.next = null;
        }
        return root;
    }
}
