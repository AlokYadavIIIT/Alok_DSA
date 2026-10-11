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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q =new ArrayDeque<>();
        if(root!=null){
            q.offer(root);
        }

        while(!q.isEmpty()){
            int lvlsize = q.size();
            List<Integer> temp = new ArrayList<>(lvlsize);

            while(lvlsize-->0){
                TreeNode t = q.poll();

                temp.add(t.val);
                if(t.left!=null){
                    q.offer(t.left);
                }

                if(t.right!=null){
                    q.offer(t.right);
                }
            }
            res.add(temp);
        }

        Collections.reverse(res);
        return res;
    }
}