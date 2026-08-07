class Solution {
    public int maxProduct(int[] nums) {
        int i=0;
        int n=nums.length;
        int minending=nums[i];
        int maxending=nums[i];
        int ans=nums[i];
        for(i=1;i<n;i++){
            int opt1=minending * nums[i];
            int opt2=maxending * nums[i];
            int opt3=nums[i];
            
            maxending=Math.max(opt1,Math.max(opt2,opt3));
            minending=Math.min(opt1,Math.min(opt2,opt3));
            // ans = Math.max(ans,Math.max(maxending,minending));
            ans=Math.max(ans,maxending);
        }
        return ans;
    }
}