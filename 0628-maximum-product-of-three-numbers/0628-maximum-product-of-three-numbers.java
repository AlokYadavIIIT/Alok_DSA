class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int left=i+1;
        //     int right=nums.length-1;

        //     while(left<right){
        //         int prod = nums[i]*nums[left]*nums[right];
        //         if(prod>max){
        //             max=prod;
        //         }
        //         left++;
        //     }
        // }
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }
}