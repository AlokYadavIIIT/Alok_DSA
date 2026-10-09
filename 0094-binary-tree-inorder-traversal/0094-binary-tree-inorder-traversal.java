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

    public void find(TreeNode node,List<Integer> in){
        if(node == null){
            return ;
        }

        find(node.left,in);//left node 
        in.add(node.val);//parent (khud)
        find(node.right,in);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> in = new ArrayList<>();
        find(root,in);
        return in;
    }
}