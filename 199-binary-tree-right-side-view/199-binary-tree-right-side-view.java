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
    static int gl = -1;
    public List<Integer> rightSideView(TreeNode root) {
        gl = -1;
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int s=0;s<size;s++){
                TreeNode node = queue.remove();
                if(s == 0) ans.add(node.val);
                
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
            
        }
        
        return ans;
        */
        
        solve(root, ans, 0);
        return ans;
    }
    
    public void solve(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        if(level > gl) { list.add(root.val); gl = level; }
        solve(root.right, list, level+1);
        solve(root.left, list, level+1);
    }
    
}