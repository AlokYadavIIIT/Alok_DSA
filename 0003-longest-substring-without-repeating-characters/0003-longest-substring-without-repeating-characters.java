class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n=s.length();
        int low=0,max=0;
        Map<Character,Integer>freq=new HashMap<>();

        for(int high=0;high<n;high++){
            int k = high-low+1;
            char c = s.charAt(high);
            freq.put(c,freq.getOrDefault(c,0)+1);
            while(freq.size()<k){
                char leftchar = s.charAt(low);
                freq.put(leftchar,freq.get(leftchar)-1);
                if(freq.get(leftchar)==0)
                    freq.remove(leftchar);
                low++;
                k=high-low+1;
            }
            max = Math.max(max,high-low+1);
        }
        return max;
    }
}