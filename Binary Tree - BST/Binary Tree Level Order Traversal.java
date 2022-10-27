// 102. Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        
        helper(ans, root, 0);
        return ans;
    }
    public void helper(List<List<Integer>> ans, TreeNode root, int level)
    {
        if(ans.size() == level)
            ans.add(new ArrayList<Integer>());
        
        ans.get(level).add(root.val);
        if(root.left != null) helper(ans, root.left, level+1);
        if(root.right != null) helper(ans, root.right, level+1);
    }
}
----------------
//2nd solution
----------------
 
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList();
        
        // If there is no tree.
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        ArrayList <Integer> level = new ArrayList<>();
        while (!q.isEmpty()){
            
            // Find the number of element in the current level
            int levelSize = q.size();
            // Iterate only for the element in this level
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                level.add(node.val);
                
                // Add the left and right child to the queue
                if (node.left !=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
            }
            // add the level to the result and reset the level arrayList
                res.add(level);
                level = new ArrayList<>();
            }
       return res; 
    }
}
