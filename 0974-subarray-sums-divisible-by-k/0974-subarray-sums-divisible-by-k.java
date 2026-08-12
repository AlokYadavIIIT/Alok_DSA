class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum=0;//prefix sum of a[0];    
        int res=0;
        HashMap<Integer,Integer> f = new HashMap<>();
        f.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;//Here this is "int ques"
            if(rem<0)//for negative remainder;
                rem=rem+k;
            int ques=f.getOrDefault(rem,0);
            res+=ques;
            f.put(rem,f.getOrDefault(rem,0)+1);
        }
        return res;
    }
}