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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right)
            return head;

        ListNode curr = head;
        ListNode before = head;
        int pos=1;

        while(curr!=null && pos<left){
            before = curr;
            curr = curr.next;
            pos++;
        }

        ListNode Left = curr;

        ListNode prev = null;
        int times=right-left+1;
        
        while(times--!=0){
            ListNode nex = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nex;

        }
        //curr= 5, prev = 4 and before = 1;

        if(left==1){
            head=prev;
        }
        else{
            before.next = prev;
        }

        Left.next=curr;

        return head;
    }
}