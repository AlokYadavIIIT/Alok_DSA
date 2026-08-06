class Solution {
    public int findDuplicate(int[] nums) {
        int slow =0;
        int fast =0;
        while(true){
            slow=nums[slow];// 1 step forward
            fast=nums[fast];// 2 step forward
            fast=nums[fast];
            if(slow==fast){
                slow=0;
                while(slow!=fast){// finding the starting point of circle
                    slow=nums[slow];
                    fast=nums[fast];
                }
                return slow;
            }
        }  
    }
}