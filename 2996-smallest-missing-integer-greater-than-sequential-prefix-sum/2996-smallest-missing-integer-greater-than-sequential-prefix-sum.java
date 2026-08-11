class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int target;
        int sum=nums[0];

        for(int i=1;i<n;i++){
            if((nums[i]-1)==nums[i-1]){
                sum+=nums[i];
            }
            else{
                break;
            }
            
        }
        //store all numbers
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        //find smallest missing integer >=sum
        target = sum;
        while(set.contains(target)){
            target++;
        }

        return target;



        //METHOD-2;Brute force;
        // target=sum;
        // for(int j=0;j<n;j++){
        //     if(nums[j]==target){
        //         target++;
        //         j=0;
        //     }
        // }
        // return target;
    }
}