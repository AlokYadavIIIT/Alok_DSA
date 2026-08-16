class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            while (!st.isEmpty() && st.peek() <= nums[index]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[index] = st.peek();
            }

            st.push(nums[index]);
        }

        return res;
    }
}


//WRONG APPROACH FOR THIS CIRCULAR ARRAY:
// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         int[] res = new int[n];
//         res[n-1]=-1;
//         Stack<Integer> st = new Stack<>();
//         st.push(nums[n-1]);
//         for(int i=n-2;i>=0;i--){
//             while(!st.isEmpty() && st.peek()<=nums[i]){
//                 st.pop();
//             }
//             if(st.isEmpty()){
//                 res[i]=-1;
//             }
//             else{
//                 res[i]=st.peek();
//             }
//             st.push(nums[i]);
//         }
//         return res;
//     }
// }