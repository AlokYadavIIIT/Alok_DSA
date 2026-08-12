class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int z=0;
        int o=0;
        int res=0;
        HashMap<Integer,Integer> f = new HashMap<>();
        f.put(0,-1);//when z=o;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                z++;
            }else{
                o++;
            }
            int diff = z-o;
            if(f.containsKey(diff)){
                int firstIndex = f.get(diff);
                res=Math.max(res,i-firstIndex);
            }else{
                f.put(diff,i);
            }
        }
        return res;
    }
}