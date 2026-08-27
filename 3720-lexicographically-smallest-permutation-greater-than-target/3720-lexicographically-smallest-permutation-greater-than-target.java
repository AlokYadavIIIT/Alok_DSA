class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[n];

        int i;

        // Try to keep prefix equal to target
        for (i = 0; i < n; i++) {

            int idx = target.charAt(i) - 'a';

            if (freq[idx] > 0) {
                ans[i] = target.charAt(i);
                freq[idx]--;
            }
            else {
                // Cannot keep equal.
                // Try to become greater at this position.

                for (int c = idx + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[i] = (char) ('a' + c);
                        freq[c]--;

                        return build(ans, i + 1, freq);
                    }
                }

                // Cannot become greater here.
                // So we need to backtrack.
                break;
            }
        }

        // Backtrack through the matched prefix
        for (int j = i - 1; j >= 0; j--) {

            // Return the character at j to freq
            int old = ans[j] - 'a';
            freq[old]++;

            int targetIdx = target.charAt(j) - 'a';

            // Find smallest character greater than target[j]
            for (int c = targetIdx + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[j] = (char) ('a' + c);
                    freq[c]--;

                    return build(ans, j + 1, freq);
                }
            }
        }

        return "";
    }

    private String build(char[] ans, int pos, int[] freq) {

        int k = pos;

        // Put remaining characters in ascending order
        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                ans[k++] = (char) ('a' + c);
                freq[c]--;
            }
        }

        return new String(ans);
    }
}