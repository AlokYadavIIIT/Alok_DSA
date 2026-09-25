class Solution {

    class pair{
        int first;//closeness;
        int second;//no.corresponding to closeness;

        pair(int f, int s ){
            first=f;
            second=s;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){
                return Integer.compare(b.first,a.first);
            }
            return Integer.compare(b.second,a.second);
        });

        for(int i=0;i<n;i++){
            int closest = Math.abs(arr[i]-x);
            pq.add(new pair(closest,arr[i]));

            if(i>=k){
                pq.poll();
            }
        }


        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            int a = pq.peek().second;
            pq.poll();
            ans.add(a);
        }
        
        Collections.sort(ans);
        
        return ans;

    }
}