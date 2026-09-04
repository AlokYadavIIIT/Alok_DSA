class Solution {

    private int largest(int[] nums,int l,int h){

        int max=Integer.MIN_VALUE;
        for(int i=l;i<=h;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        return max;
    }

    private int smallest(int[] nums,int l,int h){

        int min=Integer.MAX_VALUE;
        for(int i=l;i<=h;i++){
            if(min>nums[i]){
                min=nums[i];
            }
        }
        return min;
    }

    public int firstStableIndex(int[] nums, int k) {
        
        int n=nums.length;

        for(int i=0;i<n;i++){

            int x=largest(nums,0,i);
            int y=smallest(nums,i,n-1);
            
            int score = x-y;
            if(score <=k){//smallest first index
                return i;
            }
        }

        return -1;
    }
}