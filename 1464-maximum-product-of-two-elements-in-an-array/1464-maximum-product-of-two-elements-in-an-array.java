class Solution {
    public int maxProduct(int[] nums) {

        int max1=0,max2=0;

        for(int num:nums){
            if(num>max1){
                max2=max1;
                max1=num;
            }
            else if(num>max2){
                max2=num;
            }
        }

        return(max1-1)*(max2-1);
        // Arrays.sort(nums);
        // return (nums[nums.length-2]-1)*(nums[nums.length-1]-1);
    }
}