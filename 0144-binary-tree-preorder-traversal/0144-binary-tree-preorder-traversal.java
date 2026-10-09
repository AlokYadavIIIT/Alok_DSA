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

    public void find(TreeNode node,List<Integer> pre){
        
        if(node==null){
            return ;
        }

        pre.add(node.val);
        find(node.left,pre);
        find(node.right,pre);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> pre = new ArrayList<>();
        find(root,pre);
        return pre;
    }
}