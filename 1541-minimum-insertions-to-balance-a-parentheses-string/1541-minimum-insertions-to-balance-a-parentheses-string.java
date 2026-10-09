class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // We found a closing parenthesis ')'

                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // We have a pair '))'
                    if (open > 0) {
                        open--;
                    } else {//when previously none of '('comes.
                        insertions++;
                    }
                    i++;
                } else {
                    // Only one ')' exists; insert another ')'
                    insertions++;

                    if (open > 0) {
                        open--;
                    } else {
                        insertions++;
                    }
                }
            }
        }

        // Every remaining '(' requires two ')'
        insertions += open * 2;

        return insertions;
    }
}