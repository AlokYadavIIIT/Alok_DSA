class Solution {
    public int find(int[] nums,int low,int high){
        int res =0;
        for(int i=low;i<=high;i++){
            if(nums[i]==1){
                res++;
            }
        }
        return res;
    }
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int low=0,res=0;
        for(int high=0;high<n;high++){
            int maxone=find(nums,low,high);
            int window= high-low+1;
            int noOfZero=window-maxone;
            while(noOfZero>k){
                low++;
                maxone=find(nums,low,high);
                window=high-low+1;
                noOfZero=window-maxone;
            }
            res=Math.max(res,high-low+1);
        }
        return res;
    }
}