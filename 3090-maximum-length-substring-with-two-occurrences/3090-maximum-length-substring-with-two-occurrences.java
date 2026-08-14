class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int low = 0;
        int res=0;
        int[] freq = new int[26];
        
        int start=0;
        for(int high=0;high<n;high++){
            char c = s.charAt(high);

            freq[c-'a']++;
            //if current character occurs more that twice
            while(freq[c-'a']>2){
                freq[s.charAt(low)-'a']--;
                low++;
            }
            res = Math.max(res,high-low+1);
        }
        return res;
    }
}