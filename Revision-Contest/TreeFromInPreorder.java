import java.util.*;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        value = val;
        left = null;
        right = null;
    }
}
public class TreeFromInPreorder {
    private static int[] preOrd;
    private static int preIdx = 0;
    TreeFromInPreorder(int n){
        preOrd = new int[n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inord = new int[n];
        new TreeFromInPreorder(n);
        for (int i = 0; i < inord.length; i++) {
            inord[i] = sc.nextInt();
        }
        for (int i = 0; i < preOrd.length; i++) {
            preOrd[i] = sc.nextInt();
        }
        TreeNode root =  buildTree(inord,0,n-1);
        printPostorder(root);
        System.out.println();
        sc.close();

    }
    private static void printPostorder(TreeNode root) {
        if(root != null){
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    private static TreeNode buildTree(int[] inord,int start,int last){
        if(start > last)
            return null;

        TreeNode newNode = new TreeNode(preOrd[preIdx++]);

        if(start == last)
            return newNode;
        int rootIdx = searchNode(inord,start,last,newNode.value);

        newNode.left = buildTree(inord, start, rootIdx-1);
        newNode.right = buildTree(inord, rootIdx+1, last);
        return newNode;
    }

    private static int searchNode(int[] inord, int start, int last, int value) {
        for (int i = start; i <=last; i++) {
            if(inord[i] == value)
                return i;
        }
        return last+1;
    }
}
