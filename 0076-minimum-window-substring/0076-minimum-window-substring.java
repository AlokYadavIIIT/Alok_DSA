class Solution {

    public boolean correct(int[] have,int[] needed){
        for(int i=0;i<needed.length;i++){
            if(have[i]<needed[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)return "";
        int n = s.length();
        int m = t.length();
        int[] have = new int[256];
        int[] needed = new int[256];
        int res = Integer.MAX_VALUE;
        int start=0;
        for(int i=0;i<m;i++){
            char c = t.charAt(i);
            needed[c]++;
        }

        int low=0,high=0;
        for(high=0;high<n;high++){
            char c = s.charAt(high);
            have[c]++;
            while(correct(have,needed)){
                int len = high-low+1;
                if(res>len){
                    res=len;
                    start = low;
                }
                char d = s.charAt(low);
                have[d]--;
                low++;
            }
        }
        if(res == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+res);
    }
}