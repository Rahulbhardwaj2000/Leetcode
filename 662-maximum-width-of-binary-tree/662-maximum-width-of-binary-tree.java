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
    public int widthOfBinaryTree(TreeNode root) {
        return solve(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }
    // order tell the position of the node in the tree (like in heap)
    public int solve(TreeNode root, int lvl, int order, ArrayList<Integer> start, ArrayList<Integer> end){
        if(root == null) return 0; // width returned is 0 in base case
        if(start.size() == lvl){ // traversing down each level for first time
            start.add(order);
            end.add(order);
        }else{
            end.set(lvl, order);
        }
        
        int curr = end.get(lvl) - start.get(lvl) + 1; // calculating width for curr level
        int left = solve(root.left, lvl+1, 2*order, start, end);
        int right = solve(root.right, lvl+1, 2*order+1, start, end);
        return Math.max(curr, Math.max(left, right));
    }
}