class Solution {

    class pair{
        int first;
        char second;

        pair(int f,char s){
            first=f;
            second=s;
        }
    }

    public String reorganizeString(String s) {
        
        HashMap<Character,Integer> map=new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return b.first-a.first;
        });

        for(char key : map.keySet()){
            pq.add(new pair(map.get(key),key));
        }

        String res = "";
        int seat = 0;//position in res string;

        while(!pq.isEmpty()){

            pair p = pq.poll();
            if(seat == 0 || res.charAt(seat-1)!=p.second){
                
                res+=(p.second);
                seat++;
                p.first--;
                if(p.first>0){
                    pq.add(p);
                }
            }
            else{

                if(pq.isEmpty()){//it states like further elements as "..aaa"same;
                    return "";
                }
                pair p2=pq.poll();
                res+=(p2.second);
                seat++;
                p2.first--;
                if(p2.first>0){
                    pq.add(p2);
                }
            // Put p back because we didn't use it
                pq.add(p);
            }
        }

        return res;
    }
}