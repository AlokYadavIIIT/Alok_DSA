class Solution {

    class pair{
        int first;
        String second;

        pair(int f,String s){
            this.first=f;
            this.second=s;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String , Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++){
            String c = words[i];
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //Min heap
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(a.first!=b.first){
                return(a.first-b.first);
            }
            return b.second.compareTo(a.second);
        });

        for(String key : map.keySet()){
            pq.add(new pair(map.get(key),key));

            if(pq.size()>k){
                pq.poll();
            }
        }

        //create answer
        List<String> ans = new ArrayList<>(k);

        while(!pq.isEmpty()){
            ans.add(pq.poll().second);
        }
        // for(int i=k-1;i>=0;i--){
        //     ans.add(pq.poll().second);
        // }
        Collections.reverse(ans);
        return ans;
    }
}