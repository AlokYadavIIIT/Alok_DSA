class Solution {
    private static final int[][] FACTORS = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        int T2 = 0, T3 = 0, T5 = 0, T7 = 0;
        long temp = t;
        
        while (temp % 2 == 0) { T2++; temp /= 2; }
        while (temp % 3 == 0) { T3++; temp /= 3; }
        while (temp % 5 == 0) { T5++; temp /= 5; }
        while (temp % 7 == 0) { T7++; temp /= 7; }

        if (temp > 1) {
            return "-1";
        }

        int n = num.length();

        int z = n;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                z = i;
                break;
            }
        }

        int[] pref2 = new int[n + 1];
        int[] pref3 = new int[n + 1];
        int[] pref5 = new int[n + 1];
        int[] pref7 = new int[n + 1];

        for (int i = 0; i < Math.min(n, z); i++) {
            int d = num.charAt(i) - '0';
            pref2[i + 1] = pref2[i] + FACTORS[d][0];
            pref3[i + 1] = pref3[i] + FACTORS[d][1];
            pref5[i + 1] = pref5[i] + FACTORS[d][2];
            pref7[i + 1] = pref7[i] + FACTORS[d][3];
        }

        if (z == n) {
            if (pref2[n] >= T2 && pref3[n] >= T3 && pref5[n] >= T5 && pref7[n] >= T7) {
                return num;
            }
        }

        int maxP = Math.min(n - 1, z);
        for (int p = maxP; p >= 0; p--) {
            int R2 = Math.max(0, T2 - pref2[p]);
            int R3 = Math.max(0, T3 - pref3[p]);
            int R5 = Math.max(0, T5 - pref5[p]);
            int R7 = Math.max(0, T7 - pref7[p]);

            int dStart = (num.charAt(p) == '0') ? 1 : (num.charAt(p) - '0' + 1);
            for (int d = dStart; d <= 9; d++) {
                int rem2 = Math.max(0, R2 - FACTORS[d][0]);
                int rem3 = Math.max(0, R3 - FACTORS[d][1]);
                int rem5 = Math.max(0, R5 - FACTORS[d][2]);
                int rem7 = Math.max(0, R7 - FACTORS[d][3]);

                if (minDigits(rem2, rem3, rem5, rem7) <= n - 1 - p) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, p);
                    sb.append(d);

                    int cur2 = rem2, cur3 = rem3, cur5 = rem5, cur7 = rem7;
                    for (int j = p + 1; j < n; j++) {
                        for (int sufD = 1; sufD <= 9; sufD++) {
                            int next2 = Math.max(0, cur2 - FACTORS[sufD][0]);
                            int next3 = Math.max(0, cur3 - FACTORS[sufD][1]);
                            int next5 = Math.max(0, cur5 - FACTORS[sufD][2]);
                            int next7 = Math.max(0, cur7 - FACTORS[sufD][3]);

                            if (minDigits(next2, next3, next5, next7) <= n - 1 - j) {
                                sb.append(sufD);
                                cur2 = next2;
                                cur3 = next3;
                                cur5 = next5;
                                cur7 = next7;
                                break;
                            }
                        }
                    }
                    return sb.toString();
                }
            }
        }

        int M = minDigits(T2, T3, T5, T7);
        int L = Math.max(n + 1, M);

        StringBuilder sb = new StringBuilder();
        int cur2 = T2, cur3 = T3, cur5 = T5, cur7 = T7;
        for (int j = 0; j < L; j++) {
            for (int sufD = 1; sufD <= 9; sufD++) {
                int next2 = Math.max(0, cur2 - FACTORS[sufD][0]);
                int next3 = Math.max(0, cur3 - FACTORS[sufD][1]);
                int next5 = Math.max(0, cur5 - FACTORS[sufD][2]);
                int next7 = Math.max(0, cur7 - FACTORS[sufD][3]);

                if (minDigits(next2, next3, next5, next7) <= L - 1 - j) {
                    sb.append(sufD);
                    cur2 = next2;
                    cur3 = next3;
                    cur5 = next5;
                    cur7 = next7;
                    break;
                }
            }
        }

        return sb.toString();
    }

    private int minDigits(int r2, int r3, int r5, int r7) {
        return Math.max(0, r5) + Math.max(0, r7) + minDigits23(r2, r3);
    }

    private int minDigits23(int r2, int r3) {
        if (r2 <= 0 && r3 <= 0) return 0;
        r2 = Math.max(0, r2);
        r3 = Math.max(0, r3);

        int c9 = r3 / 2, rem3 = r3 % 2;
        int c8 = r2 / 3, rem2 = r2 % 3;

        int ans = c9 + c8;
        if (rem2 == 0 && rem3 == 0) {
            return ans;
        } else if ((rem2 == 0 && rem3 == 1) || (rem2 == 1 && rem3 == 0) || 
                   (rem2 == 1 && rem3 == 1) || (rem2 == 2 && rem3 == 0)) {
            return ans + 1;
        } else {
            return ans + 2;
        }
    }
}