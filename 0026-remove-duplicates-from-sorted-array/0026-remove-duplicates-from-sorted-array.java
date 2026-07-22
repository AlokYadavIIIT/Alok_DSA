class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(nums[j]==nums[j-1]){
                j++;
            }
            else{
                k++;
                nums[++i]=nums[j];
                j++;
            }
        }
        
        return k;
    }
}