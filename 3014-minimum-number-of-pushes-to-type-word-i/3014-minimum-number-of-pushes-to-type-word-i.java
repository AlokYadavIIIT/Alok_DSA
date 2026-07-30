class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n<=8){
            return n;
        }
        else if(8<n && n<=16){
            return 8+2*(n-8);
        }
        else if(16<n && n<=24){
            return 8+2*8+3*(n-16);
        }
        else{
            return 8+2*8+3*8+4*(n-24);
        }
        // Map<Character,Integer>freq = new HashMap<>();

        // for(int i=0;i<n;i++){
        //     char c = s.charAt(i);
        //     freq.put(c,freq.getOrDefault(c,0)+1);
        // }
        // find double=0,triple=0,single=0;
        // if(freq.size()){
        //     return n;
        // }
        // else if(){
            
        // }
    }
}