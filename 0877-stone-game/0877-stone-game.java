class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}

// class Solution {
//     Integer[][] memo;

//     public boolean predictTheWinner(int[] piles) {
//         int n=piles.length;
//         memo = new Integer[n][n];

//         return solve(piles,0,n-1)>0;
//     }

//     private int solve(int[] piles,int i,int j){
//         if(i==j){
//             return piles[i];
//         }

//         if(memo[i][j]!=null){
//             return memo[i][j];
//         }

//         int takeleft = piles[i]-solve(piles,i+1,j);
//         int takeRight = piles[j]-solve(piles,i,j-1);

//         return memo[i][j] = Math.max(takeleft,takeRight);
//     }
// }