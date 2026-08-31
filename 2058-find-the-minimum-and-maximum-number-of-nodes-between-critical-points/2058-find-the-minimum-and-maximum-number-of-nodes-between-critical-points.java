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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode first = head;
        ListNode prev = first;
        first = first.next;

        int i=1;

        int old = 0;//first critical point
        int latest=0;//previous critical point

        int min=Integer.MAX_VALUE;
        int max=-1;

        while(first.next!=null){

            ListNode nex = first.next;

            if((prev.val<first.val && first.val>nex.val)||(prev.val>first.val && first.val<nex.val)){
                //first critical point
                if(old==0){
                    old=i;
                }
                //we already have a previous critical point
                if(latest!=0){
                    min = Math.min(min,i-latest);
                }

                max=Math.max(max,i-old);
                
                latest=i;
            }
            prev=first;
            first=first.next; 
            i++;
        }
        //fewer than 2 critical points
        if(old==0|| old==latest)
            return new int[]{-1,-1};
        
        return new int[]{min,max};
    }
}