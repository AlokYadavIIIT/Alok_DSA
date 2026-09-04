class Solution {

    private long time(int[]piles,int n,int guess){

        long req=0;
        for(int i=0;i<n;i++){
            req=req+piles[i]/guess;
            if(piles[i]%guess!=0)
                req++;
        }

        return req;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int n=piles.length;
        int low=1,high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(piles[i]>high){
                high=piles[i];
            }
        }

        int res=0;
        while(low<=high){

            int guess=(low+high)/2;
            long ans=time(piles,n,guess);
            if(ans<=h){
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return res;
    }
}