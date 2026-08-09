class Solution {
    int[][] dp;
    int[] suffix;
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix[i] = total stones from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return solve(0, 1);
    }
    public int solve(int i, int M) {
        // All piles are taken
        if (i >= suffix.length - 1) {
            return 0;
        }
        // Already calculated
        if (dp[i][M] != 0) {
            return dp[i][M];
        }
        int ans = 0;
        // Try taking X piles
        for (int X = 1; X <= 2 * M && i + X <= suffix.length - 1; X++) {

            // Stones opponent can get after our move
            int opponent = solve(i + X, Math.max(M, X));

            // Total remaining stones - opponent's stones
            int currentPlayer = suffix[i] - opponent;

            ans = Math.max(ans, currentPlayer);
        }
        dp[i][M] = ans;
        return ans;
    }
}