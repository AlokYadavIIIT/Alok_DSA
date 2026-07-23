class Solution {
    public int[] sortedSquares(int[] nums) {
        // int n = nums.length;
        // List<Integer> neg = new ArrayList<>();
        // List<Integer> pos = new ArrayList<>();
        
        // for(int num : nums){
        //     if(num < 0){
        //         neg.add(num);
        //     }
        //     else{
        //         pos.add(num);
        //     }
        // }

        // //Case 1: No negative numbers
        // if(neg.size() == 0){
        //     for(int i =0;i<pos.size();i++){
        //         pos.set(i,pos.get(i)*pos.get(i));
        //     }
        //     return pos.stream().mapToInt(Integer::intValue).toArray();
        // }

        // //Case 2 : No positive numbers
        // if(pos.size()==0){
        //     for(int i=0;i<neg.size();i++){
        //         neg.set(i,neg.get(i)*neg.get(i));
                
        //     }
        //     Collections.reverse(neg);
        //     return neg.stream().mapToInt(Integer::intValue).toArray();
        // }

        // // Case 3 : Both negative and positive exist
        // int i=0 , j=0, k=0;
        // int num1=neg.size();
        // int num2=pos.size();
        // int[] res = new int[num1+num2];

        // //square negative and reverse then
        // for(i=0;i<num1;i++){
        //     neg.set(i,neg.get(i)*neg.get(i));  
        // }
        // Collections.reverse(neg);

        // //square positive
        // for(i=0;i<num2;i++){
        //     pos.set(i,pos.get(i)*pos.get(i));
        // }

        // //Merge two sorted lists
        // i=0;
        // while(i<num1 && j<num2){
        //     if(neg.get(i)<=pos.get(j)){
        //         res[k++]=neg.get(i++);
        //     }else{
        //         res[k++]=pos.get(j++);
        //     }
        // }

        // while(i<num1){
        //     res[k++]=neg.get(i++);
        // }

        // while(j<num2){
        //     res[k++]=pos.get(j++);
        // }

        // return res;

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {

            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }

        return result;
    }
}