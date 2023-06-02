package E_Tree_Questions.Calculate_Sum_of_Node_Depths;

import E_Tree_Questions.TreeNode;
import E_Tree_Questions.VisualizeTree;

public class CalculateSumNodeDepths {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(CalculateSumNodeDepth(root));
        VisualizeTree.printTree(root, null, false);
    }

    public static int CalculateSumNodeDepth(TreeNode root) {

        return nodeDepthSums(root, 0);
    }

    public static int nodeDepthSums(TreeNode node, int sums) {
        if (node == null) return 0;

        return sums + nodeDepthSums(node.left, sums + 1) + nodeDepthSums(node.right, sums + 1);
    }

}

