class Solution {
    public int findMin(int[] nums) {

      int n=nums.length;
      int low=0,high=n-1;
      int res=-5001;

      while(low<=high){
        
        int guess = (low+high)/2;

        if(nums[guess]>nums[n-1]){
            low=guess+1;
        }
        else{
            res=nums[guess];
            high=high-1;
        }
      }  
      return res;
    }
}