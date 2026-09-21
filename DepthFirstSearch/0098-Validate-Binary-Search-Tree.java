/*
 * Problem: Validate Binary Search Tree (Trees)
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * - The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * 
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false (The root node's value is 5 but its right child's value is 4)
*/

class TreeNode {
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

public class Main {
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node){
        if(node == null){
            return true;
        }

        boolean left = dfs(node.left);

        if(prev != null && node.val <= prev.val){
            return false;
        }
        prev = node;

        boolean right = dfs(node.right);

        return left && right;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: [2,1,3], [5,1,5], [3,1,2,null,null,1,6], [5,2,7,1,3,5,8]