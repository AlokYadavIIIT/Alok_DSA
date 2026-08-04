class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> missing = new ArrayList<>();
        if(nums==null || n == 0){
            return missing;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int curr = nums[i];
            int next = nums[i+1];
            for(int j=curr+1;j<next;j++){
                missing.add(j);
            }
        }
        return missing;
    }
}