class Solution {
    public int subarraySum(int[] nums, int k) {
        //Here we prefix sum bcz nums[i] belongs to (-1000,1000);
        int res=0;
        int sum=0;
        HashMap<Integer,Integer> f = new HashMap<>();
        f.put(0,1);//it means sum =0 ek baar mila h : empty array me;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            //Here sum doesn't means total sum,it say a subarray "sum"
            int ques=(sum-k);// if one part of subarray==sum-k then other = (sum) - (sum-k)= k;

            int freq = f.getOrDefault(ques,0);//it tells how many times earlier you have seen (sum-k);
            res+=freq;

            f.put(sum,f.getOrDefault(sum,0)+1);
        }
        return res;
    }
}