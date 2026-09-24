class Solution {

    class pair{
        int first;
        int second;
        pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = profits.length;

        ArrayList<pair> proj = new ArrayList<>();

        int i;
        for(i=0;i<n;i++){
            proj.add(new pair(capital[i],profits[i]));
        }

        proj.sort((a,b) -> a.first-b.first);

//Max heap for profits
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx=0;

        while(k-->0){

            //Add all affordable projects
            while(idx<n){
                if(proj.get(idx).first>w)
                    break;
                pq.add(proj.get(idx).second);
                idx++;
            }
            if(pq.isEmpty()){
                return w;
            }
            
            //Take maximum profit
            w=w+pq.peek();
            pq.poll();
        }

        return w;

    }
}