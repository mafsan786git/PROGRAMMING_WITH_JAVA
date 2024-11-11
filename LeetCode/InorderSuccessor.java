/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohdafsanahmad
 */
public class InorderSuccessor {

    private static TreeNode inOrderSuccessorNode;
    private static TreeNode prevousNode;

    public static void main(String[] args){
        TreeNode root = TreeBuilder.buildBinaryTree(new String[]{"5","3","6","2","4","null","null","1"});
        TreeNode  ans = inOrerSuccessorNodeForBST(root,root.left.right);
        if(ans != null){
            System.out.println(ans.val);
        }else{
            System.out.println("Final answer is null.");
        }

    }

    private static TreeNode inOrerSuccessorNodeForBST(TreeNode root,TreeNode p){
        if(root == null || p == null) return null;
        TreeNode succcessor = null;
        while(root != null){

            if(p.val >= root.val){
                root = root.right;
            }else{
                succcessor  = root;
                root = root.left;
            }
        }

        return succcessor;

    }


    //for all binary tree
    private static TreeNode inOrderSuccessorNode(TreeNode root,TreeNode p){
        if(root == null || p == null) return null;

        if (p.right != null) {
            TreeNode leftMostNode = p.right;
            while(leftMostNode.left != null){
                leftMostNode = leftMostNode.left;
            }
            return leftMostNode;
        }

        inOrderSuccessorNodeForOtherCases(root, p);
        return inOrderSuccessorNode;

    }

    private static void inOrderSuccessorNodeForOtherCases(TreeNode root,TreeNode p){
        if(root == null) return;

        inOrderSuccessorNodeForOtherCases(root.left,p);
        if(prevousNode == p && inOrderSuccessorNode == null){
            inOrderSuccessorNode = root;
            return;
        }
        prevousNode = root;
        inOrderSuccessorNodeForOtherCases(root.right,p);
    }

}
