// Problem: Maximum Depth of Binary Tree

// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:

// Input: root = [3,9,20,null,null,15,7] (Root is 3, children are 9 and 20. 20's children are 15 and 7).
// Output: 3

public class TreeNode {
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
	public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
            TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.offer(curr.left);
                
                if(curr.right != null)
                    queue.offer(curr.right);
            }

            level++;
        }

        return level;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
// Test cases: [],[3,null,9,null,null,null,10],[3]