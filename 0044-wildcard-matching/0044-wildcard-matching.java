class Solution {
    public boolean isMatch(String s, String p) {
         int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if the first i characters in s match the first j characters in p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches with empty pattern
        dp[0][0] = true;

        // Deal with patterns with '*', they can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    // If characters match or pattern has '?', inherit the previous state
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' can match an empty sequence (dp[i][j-1]) or any sequence (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        // The answer will be whether the entire string matches the entire pattern
        return dp[m][n];
    }
}