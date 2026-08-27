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

    private void reverse(ListNode left,int k){
        ListNode prev = null;
        ListNode curr = left;

        for(int i=0;i<k;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return head;

        ListNode left=head;
        ListNode res = null;
        ListNode prevleft = null;
        ListNode right;

        while(true){
            right=left;

            for(int i=0;i<k-1;i++){
                if(right==null)
                    break;
                right=right.next;
            }

            if(right!=null){

                ListNode nextleft=right.next;
                reverse(left,k);

                if(prevleft!=null){
                    prevleft.next=right;//1st group ka start next ke end se;
                }
                prevleft = left;

                if(res == null){
                    res = right;
                }
                left = nextleft;
            }

            else{

                if(prevleft!=null)
                    prevleft.next=left;
                
                if(res == null){
                    res = left;
                }

                break;
            }
        }

        return res;
    }
}