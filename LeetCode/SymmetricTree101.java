import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class SymmetricTree101 {

    /**
     * 
     * 3241423
     */
    
    public static void main(String[] args){
        ListNode root = TreeTraversal94.createTree();
        // List<Integer> inOrderList = new ArrayList<>();
        // TreeTraversal94.inOrderTraversal(root, inOrderList);
        System.out.println(symmatricCheckWithRecursion(root.left,root.right));
        System.out.println(symmatricCheckWithIterative(root));
    }

    //Working with recursion
    private static boolean symmatricCheckWithRecursion(ListNode leftRoot,ListNode rightRoot){
        if(leftRoot == rightRoot){
            return true;
        }
        if(leftRoot ==null || rightRoot == null){
            return false;
        }
        if(leftRoot.val != rightRoot.val){
            return false;
        }
        boolean isLeftSymmetric = symmatricCheckWithRecursion(leftRoot.left, rightRoot.right);
        boolean isRightSymmetric = symmatricCheckWithRecursion(leftRoot.right, rightRoot.left);
        return isLeftSymmetric && isRightSymmetric;
    }

    private static boolean symmatricCheckWithIterative(ListNode root){
        Queue<ListNode> leftQueue = new LinkedList<>();
        Queue<ListNode> rightQueue = new LinkedList<>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            ListNode leftNode = leftQueue.poll();
            ListNode rightNode = rightQueue.poll();
            if(leftNode == rightNode){
                continue;
            }
            if(leftNode == null || rightNode == null){
                return false;
            }
            if(leftNode.val != rightNode.val){
                return false;
            }
            leftQueue.add(leftNode.left);
            leftQueue.add(leftNode.right);
            rightQueue.add(rightNode.right);
            rightQueue.add(rightNode.left);
        }
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }
}
