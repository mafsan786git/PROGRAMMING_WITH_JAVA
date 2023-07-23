import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class TreeTraversal94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        List<Integer> answer = new ArrayList<>();
        answer = inOrderTraversal(tree,answer);
        System.out.println(answer);
        answer = new ArrayList<Integer>();
        answer = inOrderTraversalByStack(tree,answer);
        System.out.println(answer);
    }

    public static List<Integer> inOrderTraversal(TreeNode root,List<Integer> list) {
        if(root == null)
            return list;

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
        return list;
    }

    private static List<Integer> inOrderTraversalByStack(TreeNode root,List<Integer> answer){
        if(root == null){
            return answer;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
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
