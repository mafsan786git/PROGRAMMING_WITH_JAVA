public class TreeBuilder {

    // Method to insert a node in the BST
    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // Public method to build a BST from an array of strings
    public static TreeNode buildBST(String[] arr) {
        TreeNode root = null;
        for (String s : arr) {
            if (!s.equals("null")) { // Skip "null" values
                int val = Integer.parseInt(s);
                root = insertIntoBST(root, val);
            }
        }
        return root;
    }

    // New method to create a binary tree from array using index-based relationships
    public static TreeNode buildBinaryTree(String[] arr) {
        return buildBinaryTreeHelper(arr, 0);
    }

    // Helper function to build the binary tree from array
    private static TreeNode buildBinaryTreeHelper(String[] arr, int index) {
        if (index >= arr.length || arr[index].equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        node.left = buildBinaryTreeHelper(arr, 2 * index + 1);   // Left child at 2*i + 1
        node.right = buildBinaryTreeHelper(arr, 2 * index + 2);  // Right child at 2*i + 2
        return node;
    }

    // Utility method to print the BST in-order for debugging
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
}
