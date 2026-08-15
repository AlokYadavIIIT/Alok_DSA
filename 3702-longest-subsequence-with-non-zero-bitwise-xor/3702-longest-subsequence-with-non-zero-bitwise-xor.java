class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor =0;
        boolean hasNonzero = false;

        for(int num:nums){
            xor ^=num;

            if(num!=0){
                hasNonzero=true;
            }
        }
        if(xor!=0){
            return n;
        }

        if(hasNonzero){
            return n-1;
        }
        return 0;
    }
}