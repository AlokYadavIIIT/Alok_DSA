class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int result=0;
        int maxdiff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){

            int left = i+1;
            int right = nums.length-1;
            
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                int close = Math.abs(sum-target);
                if(sum==target){
                    return sum;
                }
                else if (sum<target){
                    if(maxdiff>close){
                        maxdiff=close;
                        result=sum;
                    }
                    left++;
                }
                else{
                    if(maxdiff>close){
                        maxdiff=close;
                        result=sum;
                    }
                    right--;
                }
            }
        }
        return result;
    }
}