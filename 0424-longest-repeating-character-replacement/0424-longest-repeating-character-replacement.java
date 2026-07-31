class Solution {
    // public int find(int[] a){
    //     int maxc=-1;
    //     for(int i=0;i<256;i++){
    //         maxc = Math.max(maxc,a[i]);
    //     }
    //     return maxc;
    // }
    public int characterReplacement(String s, int k) {
        // int n = s.length();
        // int[] f=new int[256];
        // int low=0,high=0,res=0;
        // for(high=0;high<n;high++){
        //     f[s.charAt(high)]++;
        //     int maxcnt= find(f);
        //     int len=high-low+1;
        //     int diff=len-maxcnt;
        //     while(diff>k){
        //         f[s.charAt(low)]--;
        //         low++;
        //         maxcnt=find(f);
        //         len=high-low+1;
        //         diff=len-maxcnt;
        //     }
        //     res=Math.max(res,high-low+1);
        // }
        // return res;

        int[] freq = new int[26];
        int low=0;
        int maxfreq=0;
        int res=0;

        for(int high=0;high<s.length();high++){
            maxfreq=Math.max(maxfreq,++freq[s.charAt(high)-'A']);

            while((high-low+1)-maxfreq > k){
                freq[s.charAt(low)-'A']--;
                low++;
            }

            res = Math.max(res,high-low+1);
        }
        return res;
    }
}