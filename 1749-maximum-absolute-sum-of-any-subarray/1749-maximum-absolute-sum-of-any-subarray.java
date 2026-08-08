class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int i=0;
        int n=nums.length;
        int minending=nums[i];
        int maxending=nums[i];
        int ans=Math.abs(nums[i]);
        for(i=1;i<n;i++){
            int opt3=nums[i];

            maxending=Math.max(maxending+nums[i],opt3);
            minending=Math.min(minending+nums[i],opt3);
            int currentmax=Math.max(Math.abs(minending),Math.abs(maxending));
            ans=Math.max(ans,currentmax);
        }
        return ans;
    }
}