class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int n=nums.length;

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        int i;
        for(i=0;i<k;i++){
            minheap.add(nums[i]);
        }

        for(i=k;i<n;i++){
            if(nums[i]<=minheap.peek()){
                continue;
            }
            minheap.poll();
            minheap.add(nums[i]);
        }

        return minheap.peek();
    }
}