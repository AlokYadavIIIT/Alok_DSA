// class Solution {
//     public int minSumOfLengths(int[] arr, int target) {

//         int n = arr.length;
//         int INF = Integer.MAX_VALUE;

//         // best[i] = minimum length of a valid subarray
//         // ending at or before index i
//         int[] best = new int[n];

//         for (int i = 0; i < n; i++) {
//             best[i] = INF;
//         }

//         int left = 0;
//         int sum = 0;
//         int minLen = INF;
//         int ans = INF;

//         for (int right = 0; right < n; right++) {

//             sum += arr[right];

//             // Shrink window if sum becomes greater than target
//             while (sum > target) {
//                 sum -= arr[left];
//                 left++;
//             }

//             // We found a subarray with sum = target
//             if (sum == target) {

//                 int len = right - left + 1;

//                 // Check whether there is a previous
//                 // non-overlapping subarray
//                 if (left > 0 && best[left - 1] != INF) {
//                     ans = Math.min(ans, len + best[left - 1]);
//                 }

//                 // Keep the shortest subarray found so far
//                 minLen = Math.min(minLen, len);
//             }

//             // Best answer available up to this index
//             best[right] = minLen;
//         }

//         return ans == INF ? -1 : ans;
//     }
// }



// METHOD - 2 :
class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Initially no valid subarray
        for (int i = 0; i < n; i++) {
            prefix[i] = INF;
            suffix[i] = INF;
        }

        // -------------------------
        // BUILD PREFIX ARRAY
        // -------------------------

        int left = 0;
        int sum = 0;
        int minLen = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int len = right - left + 1;
                minLen = Math.min(minLen, len);
            }

            prefix[right] = minLen;
        }

        // -------------------------
        // BUILD SUFFIX ARRAY
        // -------------------------

        int right = n - 1;
        sum = 0;
        minLen = INF;

        for (int leftIndex = n - 1; leftIndex >= 0; leftIndex--) {

            sum += arr[leftIndex];

            while (sum > target) {
                sum -= arr[right];
                right--;
            }

            if (sum == target) {
                int len = right - leftIndex + 1;
                minLen = Math.min(minLen, len);
            }

            suffix[leftIndex] = minLen;
        }

        // -------------------------
        // COMBINE PREFIX + SUFFIX
        // -------------------------

        int ans = INF;

        for (int i = 0; i < n - 1; i++) {

            if (prefix[i] != INF && suffix[i + 1] != INF) {

                ans = Math.min(ans,
                        prefix[i] + suffix[i + 1]);
            }
        }

        return ans == INF ? -1 : ans;
    }
}