class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int i=0;
//when array is straight:max is in b/w.
        int max1=nums[i];
        int res1=nums[i];
        for(i=1;i<n;i++){
            max1=Math.max(max1+nums[i],nums[i]);
            res1=Math.max(res1,max1);
        }
//when array is circular:both end is positive or say min in b/w.
        int max2;
        int totalsum=0;
        for(int k=0;k<n;k++){
            totalsum+=nums[k];
        }
        int j=0;
        int min2=nums[j];
        int res2=nums[j];
        for(j=1;j<n;j++){
            min2=Math.min(min2+nums[j],nums[j]);
            res2=Math.min(res2,min2);
        }
        max2=totalsum-res2;

        if(res1<0){// if it -ve it means max2 ==0;
            return res1;
        }else{
            int res = Math.max(res1,max2);
            return res; 
        }
        
    }
}