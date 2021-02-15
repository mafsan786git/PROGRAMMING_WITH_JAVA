import java.util.Scanner;

public class ConvertIntoTree {
    private static int[] inorder;
    private static int[] preorder;
    ConvertIntoTree(int n){
        inorder = new int[n];    
        preorder = new int[n];    
    }
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right = null;
        }        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        new ConvertIntoTree(n);
        for (int i = 0; i < preorder.length; i++) {
            inorder[i] = sc.nextInt();
        }
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = sc.nextInt();
        }
        int j=0;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if(preorder[j] == inorder[i])
            {
                binaryTree(0,i-1,j+1,root);
                binaryTree(i+1,n-1,j+1,root);
                
            }
        }
    }

    private static void binaryTree(int leftIdx, int rightIdx, int rootIdx,TreeNode root) {
        if(leftIdx >=0 && rightIdx <=0){
            root.left  = null;
            return ;
        }
        if(leftIdx >=preorder.length-1 && rightIdx <= preorder.length-1){
            root.right = null;
            return;
        }

        for (int i = leftIdx; i <= rightIdx; i++) {
            if(preorder[rootIdx] == inorder[i])
            {
                binaryTree(leftIdx,i-1,rootIdx+1,root);
                binaryTree(i+1,rightIdx,rootIdx+1,root);
            }
        }

        

    }
    
}
