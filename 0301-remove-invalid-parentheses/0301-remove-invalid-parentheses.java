class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;
            } 
            else if (c == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(String s, int index,
                     int leftRemove, int rightRemove,
                     int balance, StringBuilder current) {

        // If balance becomes negative, ')' appeared without '('
        if (balance < 0) {
            return;
        }

        // Reached the end
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(current.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // Case 1: Current character is '('
        if (c == '(') {

            // Remove it
            if (leftRemove > 0) {
                dfs(s, index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    current);
            }

            // Keep it
            current.append(c);

            dfs(s, index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current);

            current.deleteCharAt(current.length() - 1);
        }

        // Case 2: Current character is ')'
        else if (c == ')') {

            // Remove it
            if (rightRemove > 0) {
                dfs(s, index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    current);
            }

            // Keep it
            if (balance > 0) {

                current.append(c);

                dfs(s, index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    current);

                current.deleteCharAt(current.length() - 1);
            }
        }

        // Case 3: Letter
        else {

            current.append(c);

            dfs(s, index + 1,
                leftRemove,
                rightRemove,
                balance,
                current);

            current.deleteCharAt(current.length() - 1);
        }
        
    }
}