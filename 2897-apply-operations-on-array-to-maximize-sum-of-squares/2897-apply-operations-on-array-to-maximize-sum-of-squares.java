
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] count = new int[31];

        // Step 1: Count set bits at every position
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    count[bit]++;
                }
            }
        }

        long ans = 0;

        // Step 2: Build k maximum numbers
        for (int i = 0; i < k; i++) {
            int num = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (count[bit] > 0) {
                    num |= (1 << bit);
                    count[bit]--;
                }
            }

            // Step 3: Add the square modulo MOD
            ans = (ans + (long) num * num) % MOD;
        }

        return (int) ans;
    }
}
