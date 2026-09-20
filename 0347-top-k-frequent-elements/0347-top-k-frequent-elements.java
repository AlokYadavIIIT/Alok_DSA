class Solution {
    class pair{
        int first;
        int second;

        pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int c = nums[i];
            map.put(c,map.getOrDefault(c,0)+1);
        }

        // Min heap;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){
                return (a.first-b.first);
            }
            return (a.second - b.second);
        });

        for(int key : map.keySet()){
            pq.add(new pair(map.get(key),key));

            if(pq.size()>k){
                pq.poll();
            }
        }

        //create answer
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().second;
        }

        return ans;
    }
}