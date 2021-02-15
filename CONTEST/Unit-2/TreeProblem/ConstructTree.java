
import java.io.*;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class ConstructTree {
    static class TreeNode{
        static TreeNode newNode=null;
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(){
            this.data = 0;
            this.left = null;
            this.right  = null;
        }
        TreeNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int numberOfNodes = Integer.parseInt(input.nextToken());
        int topNode = Integer.parseInt(input.nextToken());
        TreeNode root = new TreeNode(topNode);
        for (int i = 1; i < numberOfNodes; i++) {
            input = new StringTokenizer(br.readLine());
            String str = input.nextToken().toString();
            input = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(input.nextToken());
            TreeNode.newNode = new TreeNode(data);
            addNodeInTree(root,str,0);
        }
        postOrderTraversal(root);
    }

    private static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        HashSet<TreeNode> vis = new HashSet<>();
        while(!stack.isEmpty()){
            root = stack.peek();
            if(root.left != null && !vis.contains(root.left))
                stack.add(root.left);
            else if(root.right != null && !vis.contains(root.right))
                stack.add(root.right);
            else{
                System.out.print(root.data + " ");
                vis.add(stack.pop());
            } 
        }

    }

    private static void addNodeInTree(TreeNode root, String str, int idx) {
        if(idx == str.length()-1){
            if(str.charAt(idx) == 'L')
            {
                if(root.left == null)
                    root.left = TreeNode.newNode;
                else
                    root.left.data = TreeNode.newNode.data;
            }
            if(str.charAt(idx) == 'R')
            {
                if(root.right == null)
                    root.right =  TreeNode.newNode;
                else
                    root.right.data = TreeNode.newNode.data;
            }
        }else{
            if(str.charAt(idx) == 'L'){
                if(root.left == null)
                    root.left = new TreeNode();
                addNodeInTree(root.left, str, idx+1);
            }
            if(str.charAt(idx) == 'R'){
                if(root.right == null)
                    root.right = new TreeNode();
                addNodeInTree(root.right, str, idx+1);
            }
                
        }
    }
    
}
