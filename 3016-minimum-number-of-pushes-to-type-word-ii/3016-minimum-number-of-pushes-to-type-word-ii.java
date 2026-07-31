class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int res=0;
        Map<Character,Integer> freq = new HashMap<>();

        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int diff=freq.size();
        int[] arr = new int[diff];
        
        int idx=0;
        for(int count:freq.values()){
            arr[idx++]=count;
        }
        Arrays.sort(arr);
        if(diff<=8){
            for(int i=diff-1;i>-1;i--){
                res+=arr[i]*1;
            }
        }
        else if(diff>8 && diff<=16){
            for(int i=diff-1;i>-1;i--){
                if(i>diff-9){
                    res+=arr[i]*1;
                }
                else{
                    res+=arr[i]*2;
                }
            }
        }
        else if(diff>16 && diff<=24){
            for(int i=diff-1;i>-1;i--){
                if(i>diff-9){
                    res+=arr[i]*1;
                }
                else if(i>diff-17){
                    res+=arr[i]*2;
                }
                else{
                    res+=arr[i]*3;
                }
            }
        }
        else{
            for(int i=diff-1;i>-1;i--){
                if(i>diff-9){
                    res+=arr[i]*1;
                }
                else if(i>diff-17){
                    res+=arr[i]*2;
                }
                else if(i>diff-25){
                    res+=arr[i]*3;
                }
                else{
                    res+=arr[i]*4;
                }
            }
        } 
        return res;  
    }
}