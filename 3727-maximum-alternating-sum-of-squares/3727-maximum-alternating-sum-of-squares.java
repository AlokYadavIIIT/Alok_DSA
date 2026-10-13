class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);

        long score= 0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            long square = (long) nums[i]*nums[i];

            if(i<n/2){
                score-=square;
            }else{
                score+=square;
            }
        }

        return score;
    }
}