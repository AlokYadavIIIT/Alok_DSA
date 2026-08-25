class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        int n = nums.length;
        ArrayList<Integer> quotient = new ArrayList<>();

        int max = nums.length+1;

        for(int i=0;i<n;i++){
            if(max<nums[i] && nums[i]%k==0)
                max=nums[i];
        }
//here we use i<=max/k bcz it starts from 0 and 0 never be any quotient 
// +1 because quotient itself is used as an index
        for(int i=0;i<=max/k;i++){
            quotient.add(0);
        }

        for(int i=0;i<n;i++){
            int quot = nums[i]/k;

            if(quot !=0 && nums[i]%k ==0 ){
                quotient.set(quot,1);
            }
        }

        for(int i=1;i<quotient.size();i++){
            if(quotient.get(i)==0){
                return k*(i);
            }
        }

        return k*(quotient.size());
    }
}