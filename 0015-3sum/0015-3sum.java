class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            //Skipping the duplicate first elements;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left=i+1;
            int right=nums.length-1;
            int sum = -1*nums[i];
            while(left<right){

                if(sum == nums[left]+nums[right]){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[left]+nums[right]<sum){
                    left++;
                }
                else{
                    right--;
                }
            }

        }
        return result;
    }
}