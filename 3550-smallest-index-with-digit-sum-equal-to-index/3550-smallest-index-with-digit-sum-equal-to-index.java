class Solution {
    public int smallestIndex(int[] nums) {
        
        int n=nums.length;
        
        for(int i=0;i<n;i++){

            int d=0;
            while(nums[i]>0){
                d+=nums[i]%10;
                nums[i]/=10;
            }

            if(i==d){
                return i;
            }
        }

        return -1;
    }
}