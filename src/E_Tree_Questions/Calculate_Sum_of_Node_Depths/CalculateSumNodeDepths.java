package D_LinkedList_Questions.Calculate_Sum_of_Node_Depths;

public class CalculateSumNodeDepths {

    public static int CalculateSumNodeDepth(TreeNode root) {

        return nodeDepthSums(root, 0);
    }

    public static int nodeDepthSums(TreeNode node, int sums) {
        if (node == null) return 0;

        return sums + nodeDepthSums(node.left, sums + 1) + nodeDepthSums(node.right, sums + 1);
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
