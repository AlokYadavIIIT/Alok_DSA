class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        HashMap<Character,Integer> freq = new HashMap<>();

        for(int i=0;i<n;i++){
            char c =s.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(freq.get(c)==1){
                return i;
            }
        }
        return -1;
    }
}