class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int low =0;
        int lon=0;
        Map<Character,Integer> freq=new HashMap<>();

        for(int high=0;high<n;high++){
            char c = s.charAt(high);

            //if char already seen,move left pointer after its last occurence
            if(freq.containsKey(c)){
                low = Math.max(low,freq.get(c)+1);
            }

            freq.put(c,high);
            lon = Math.max(lon,high-low+1);
        }
        return lon;
    }
}