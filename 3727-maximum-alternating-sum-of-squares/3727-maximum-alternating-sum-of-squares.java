class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            nums[i]*=(nums[i]);
        }

        Arrays.sort(nums);

        long score= 0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            // long square = (long) nums[i]*nums[i];

            if(i<n/2){
                score-=nums[i];
            }else{
                score+=nums[i];
            }
        }

        return score;
    }
}