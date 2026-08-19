class Solution {
    Map<Integer,Integer> dp;

    int sol(int[] a,int i){
        if(i>=a.length)return 0;

        if(dp.containsKey(i)){
            return dp.get(i);
        }

        int diff=Integer.MIN_VALUE;

        int sum=0;
        int prev=0;

        for(int j=i;j<i+3 && j<a.length;j++){
            prev+=a[j];
            sum=prev-sol(a,j+1);
            diff=Math.max(diff,sum);
        }

        dp.put(i,diff);
        return diff;
    }
    
    public String stoneGameIII(int[] stoneValue) {
        dp=new HashMap<>();
        int score=sol(stoneValue,0);
        if(score>0){
            return "Alice";
        }
        else if(score<0){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }
}