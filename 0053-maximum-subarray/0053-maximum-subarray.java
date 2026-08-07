class Solution {
    public int maxSubArray(int[] nums) {
        int i=0;
        int bestending=nums[0];
        int ans=nums[0];
        for(i=1;i<nums.length;i++){
            int opt1=bestending+nums[i];
            int opt2=nums[i];
            bestending=Math.max(opt1,opt2);
            ans=Math.max(ans,bestending);
        }
        return ans;
    }
}