package E_Tree_Questions.Symmetric_Tree_LC_Easy;

import E_Tree_Questions.TreeNode;
import E_Tree_Questions.VisualizeTree;

import java.util.Stack;

public class SymmetricTree_LC_Easy {
    /*
    101. Symmetric Tree
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?
     */

    public static void main(String[] args) {
//        Integer[] ints = {1, 2, 2, null, 3, null, 3};
//        TreeNode root = new TreeNode(1);
//        for (Integer i : ints) {
//            if (i != null) insert(root, i);
//        }
//        VisualizeTree.printTree(root, null, false);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }


    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    static boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean withStack(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }

//    static void insert(TreeNode root, int value) {
//        TreeNode newNode = new TreeNode(value);
//        if (root == null) {
//            root = newNode;
//            return;
//        }
//        TreeNode current = root;
//        while (true) {
//            if (value <= current.val) {
//                if (current.left == null) {
//                    current.left = newNode;
//                    break;
//                }
//                //if leftChild is not null branch into left subtree!!
//                current = current.left;
//            } else {
//                if (current.right == null) {
//                    current.right = newNode;
//                    break;
//                }
//                //if rightChild is not null branch into right subtree!!
//                current = current.right;
//            }
//
//        }
//    }


}
