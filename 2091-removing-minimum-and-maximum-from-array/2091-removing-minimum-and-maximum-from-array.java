// class Solution {
//     public int minimumDeletions(int[] nums) {
//         int n = nums.length;
//         int left = 0;
//         int right = 0;
        
//         for (int i = 1; i < n; i++) {
//             if (nums[i] < nums[left])
//                 left = i;
                
//             if (nums[i] > nums[right])
//                 right = i;
//         }
        
//         if (left < right) {
//             int temp = left;
//             left = right;
//             right = temp;
//         }
            
//         int ans = n;
        
//         for (int i = 0; i <= n; i++) {
//             int extra = 0;
            
//             if (right >= i)
//                 extra = n - right;
//             else if (left >= i)
//                 extra = n - left;
                
//             ans = Math.min(ans, i + extra);
//         }
        
//         return ans;
//     }
// }







class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0, maxIndex = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[minIndex]) minIndex = i;
            if(nums[i] > nums[maxIndex]) maxIndex = i;
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Remove both from the front
        int front = right + 1;

        // Remove both from the back
        int back = n - left;

        // Remove one from each side
        int frontBack = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, frontBack));
    }
}