public class DepthBinaryTree104 {
    
    public static void main(String[] arg){
        ListNode rootNode = TreeTraversal94.createTree();
        int maxDepth = 0;
        // if(rootNode != null){
        //     maxDepth = 1;
        // }
        System.out.println(depthOfBinaryTree(rootNode,maxDepth));
    }

    private static int depthOfBinaryTree(ListNode root , int maxDepth){
        if(root == null){
            return maxDepth;
        }
        maxDepth = Math.max(Math.max(depthOfBinaryTree(root.left, maxDepth+1), depthOfBinaryTree(root.right, maxDepth+1)),maxDepth);
        return maxDepth;
    }
}
