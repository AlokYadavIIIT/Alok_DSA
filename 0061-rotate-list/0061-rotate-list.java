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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k==0) {
            return head;
        }
        
        int n=1;
        ListNode last = head;

        while(last.next!=null){
            last=last.next;
            n++;
        }

        int rot=k%n;
        if(rot==0){
            return head;
        }
        
        //make circular
        last.next=head;

        int steps = n-rot-1;
        ListNode newtail=head;

        while(steps--!=0){
            newtail=newtail.next;
        }

        ListNode nex=newtail.next;
        newtail.next=null;
        

        return nex;
    }
}