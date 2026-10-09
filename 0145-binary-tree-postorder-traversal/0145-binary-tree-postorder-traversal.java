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

    public void find(TreeNode node,List<Integer> post){

        if(node==null){
            return;
        }
        find(node.left,post);
        find(node.right,post);
        post.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> post = new ArrayList<>();
        find(root,post);
        return post;
    }
}