import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal94 {

    public static void main(String[] args) {
        ListNode tree = createTree();
        List<Integer> answer = new ArrayList<>();
        answer = inOrderTraversal(tree,answer);
        System.out.println(answer);
        answer = new ArrayList<Integer>();
        answer = inOrderTraversalByStack(tree,answer);
        System.out.println(answer);
    }
public static ListNode createTree(){
        ListNode tree = new ListNode();
        tree = new ListNode(1);
        tree.left = new ListNode(2);
        tree.right = new ListNode(2);
        tree.right.left = new ListNode(4);
        tree.right.right = new ListNode(3);
        return tree;
    }

public static List<Integer> inOrderTraversal(ListNode root,List<Integer> list) {
        if(root == null)
            return list;

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
        return list;
}
public static List<Integer> preOrderTraversal(ListNode root,List<Integer> list) {
    if(root == null)
        return list;

    list.add(root.val);
    preOrderTraversal(root.left, list);
    preOrderTraversal(root.right, list);
    return list;
}


private static List<Integer> inOrderTraversalByStack(ListNode root,List<Integer> answer){
        if(root == null){
            return answer;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = root;
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            answer.add(curr.val);
            curr = curr.right;
        }
        return answer;
    }
}
