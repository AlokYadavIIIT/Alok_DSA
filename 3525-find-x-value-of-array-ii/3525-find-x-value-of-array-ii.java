// class Solution {
//     static class Node {
//         int prod;
//         int[] freq;
//         Node(int k) {
//             prod = 1;
//             freq = new int[k];
//         }
//     }
    
//     int k;
//     Node[] tree;
//     int[] nums;
    
//     Node merge(Node L, Node R) {
//         Node res = new Node(k);
//         res.prod = (int)((1L * L.prod * R.prod) % k);
//         System.arraycopy(L.freq, 0, res.freq, 0, k);
//         for (int r = 0; r < k; r++) {
//             if (R.freq[r] != 0) {
//                 int nr = (int)((1L * L.prod * r) % k);
//                 res.freq[nr] += R.freq[r];
//             }
//         }
//         return res;
//     }
    
//     void build(int v, int tl, int tr) {
//         if (tl == tr) {
//             tree[v].prod = nums[tl] % k;
//             tree[v].freq[tree[v].prod] = 1;
//             return;
//         }
//         int tm = (tl + tr) / 2;
//         build(v * 2, tl, tm);
//         build(v * 2 + 1, tm + 1, tr);
//         tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
//     }
    
//     void update(int v, int tl, int tr, int pos, int val) {
//         if (tl == tr) {
//             tree[v].prod = val % k;
//             Arrays.fill(tree[v].freq, 0);
//             tree[v].freq[tree[v].prod] = 1;
//             return;
//         }
//         int tm = (tl + tr) / 2;
//         if (pos <= tm) update(v * 2, tl, tm, pos, val);
//         else update(v * 2 + 1, tm + 1, tr, pos, val);
//         tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
//     }
    
//     Node query(int v, int tl, int tr, int l, int r) {
//         if (l > r) return new Node(k);
//         if (l == tl && r == tr) return tree[v];
//         int tm = (tl + tr) / 2;
//         return merge(query(v * 2, tl, tm, l, Math.min(r, tm)),
//                      query(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
//     }
    
//     public int[] resultArray(int[] nums, int k, int[][] queries) {
//         this.k = k;
//         this.nums = nums;
//         int n = nums.length;
//         tree = new Node[4 * n];
//         for (int i = 0; i < tree.length; i++) tree[i] = new Node(k);
//         build(1, 0, n - 1);
//         int[] ans = new int[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             int idx = queries[i][0], val = queries[i][1], start = queries[i][2], x = queries[i][3];
//             update(1, 0, n - 1, idx, val);
//             Node res = query(1, 0, n - 1, start, n - 1);
//             ans[i] = res.freq[x];
//         }
//         return ans;
//     }
// }


class Solution {
    private static class Info {
        int[] ways;
        int whole;

        Info(int k) {
            ways = new int[k];
            whole = 1;
        }
    }

    private static class SegmentTree {
        int size;
        int mod;
        Info[] tree;

        SegmentTree(int[] nums, int k) {
            mod = k;
            size = 1;

            while (size < nums.length) {
                size <<= 1;
            }

            tree = new Info[size * 2];

            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Info(k);
            }

            for (int i = 0; i < nums.length; i++) {
                int rem = nums[i] % k;

                tree[size + i].ways[rem] = 1;
                tree[size + i].whole = rem;
            }

            for (int i = size - 1; i > 0; i--) {
                tree[i] = combine(tree[i << 1], tree[i << 1 | 1]);
            }
        }

        private Info combine(Info left, Info right) {
            Info merged = new Info(mod);

            for (int r = 0; r < mod; r++) {
                merged.ways[r] = left.ways[r];
            }

            for (int r = 0; r < mod; r++) {
                if (right.ways[r] == 0) {
                    continue;
                }

                int newRem = (left.whole * r) % mod;
                merged.ways[newRem] += right.ways[r];
            }

            merged.whole = (left.whole * right.whole) % mod;

            return merged;
        }

        void update(int index, int value) {
            int pos = size + index;
            int rem = value % mod;

            Arrays.fill(tree[pos].ways, 0);
            tree[pos].ways[rem] = 1;
            tree[pos].whole = rem;

            pos >>= 1;

            while (pos > 0) {
                tree[pos] = combine(
                    tree[pos << 1],
                    tree[pos << 1 | 1]
                );

                pos >>= 1;
            }
        }

        Info query(int left, int right) {
            Info leftPart = new Info(mod);
            Info rightPart = new Info(mod);

            left += size;
            right += size;

            while (left < right) {
                if ((left & 1) != 0) {
                    leftPart = combine(leftPart, tree[left]);
                    left++;
                }

                if ((right & 1) != 0) {
                    right--;
                    rightPart = combine(tree[right], rightPart);
                }

                left >>= 1;
                right >>= 1;
            }

            return combine(leftPart, rightPart);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        SegmentTree tree = new SegmentTree(nums, k);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            tree.update(index, value);

            Info result = tree.query(start, nums.length);
            answer[i] = result.ways[x];
        }

        return answer;
    }
}