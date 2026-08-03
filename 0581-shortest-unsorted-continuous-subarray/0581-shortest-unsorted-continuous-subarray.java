class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // int n= nums.length;

        // int[] sorted = nums.clone();
        // Arrays.sort(sorted);
        // int left=0;
        // while(left<n && nums[left]==sorted[left]){
        //     left++;
        // }
        // if(left==n)return 0;
        // int right=n-1;
        // while(right>=0 && nums[right]==sorted[right]){
        //     right--;
        // }
        // return right-left+1;


        int n=nums.length;
        int start=-1 , end=-2;//handles already sorted cases
        int max=nums[0];
        int min=nums[n-1];

        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<max){
                end=i;
            }
        }
        for(int i=n-2;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]>min){
                start=i;
            }
        }
        return end-start+1;
    }
}