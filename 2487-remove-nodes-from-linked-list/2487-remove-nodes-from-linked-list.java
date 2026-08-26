/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        
        Stack<ListNode> stack = new Stack<>();
        
        ListNode curr = head;

//Put all nodes into the stack
        while(curr!=null){
            stack.push(curr);
            curr=curr.next;
        }

        int max=0;
        ListNode result = null;

        //Traverse from right to left;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();

            if(node.val >=max){
                node.next = result;
                result=node;
                max=node.val;
            }
        }

        return result;
    }
}