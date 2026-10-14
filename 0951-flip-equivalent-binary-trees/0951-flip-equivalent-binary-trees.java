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

    public boolean find(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }

        //case 1 : No flip
        boolean noflip = find(root1.left,root2.left)&&find(root1.right ,root2.right);

        //case 2 : flip
        boolean flip = find(root1.left,root2.right)&&
        find(root1.right,root2.left);

        return noflip || flip;
        
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        return find(root1,root2);

    }
}