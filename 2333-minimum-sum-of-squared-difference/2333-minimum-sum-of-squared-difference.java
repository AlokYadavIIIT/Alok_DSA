// import java.util.*;

// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

//         PriorityQueue<Integer> pq =
//             new PriorityQueue<>(Collections.reverseOrder());

//         long operations = (long) k1 + k2;

//         for (int i = 0; i < nums1.length; i++) {
//             int diff = Math.abs(nums1[i] - nums2[i]);
//             pq.offer(diff);
//         }

//         while (operations > 0 && !pq.isEmpty()) {
//             int maxDiff = pq.poll();

//             if (maxDiff == 0) {
//                 break;
//             }

//             pq.offer(maxDiff - 1);
//             operations--;
//         }

//         long ans = 0;

//         while (!pq.isEmpty()) {
//             long diff = pq.poll();
//             ans += diff * diff;
//         }

//         return ans;
//     }
// }


//Method -2:
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        // We can make all differences zero
        if (k >= totalDiff) {
            return 0L;
        }

        // Binary search for the smallest possible maximum difference
        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long needed = 0;
        long ans = 0;

        // Reduce every difference above limit down to limit
        for (int d : diff) {
            if (d > limit) {
                needed += d - limit;
            }

            int reduced = Math.min(d, limit);
            ans += (long) reduced * reduced;
        }

        // Use remaining operations to reduce some limit values by 1
        long remaining = k - needed;

        ans -= remaining * (2L * limit - 1);

        return ans;
    }
}
