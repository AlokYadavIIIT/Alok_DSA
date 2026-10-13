/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode ans = null;
    
    public int find(TreeNode root,TreeNode p , TreeNode q){

        if(root==null){
            return 0;
        }

        int left = find(root.left,p,q);
        int right = find(root.right,p,q);

        int self=0;
        if(root == p || root==q){
            self=1;
        }
//Since recursion from top to bottom but it returns ans from bottom to top so here we can store first node which being boss of 2 nodes; 
        int total = left+self+right;
        if(total == 2 && ans == null){
            ans = root;//storing in global variable;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        find(root,p,q);
        return ans;
    }
}