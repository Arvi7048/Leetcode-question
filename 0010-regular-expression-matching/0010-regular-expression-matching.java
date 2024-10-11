class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns with '*' that can match empty strings
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' can eliminate the preceding character
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);  // current char in string s
                char pc = p.charAt(j - 1);  // current char in pattern p

                if (pc == '.' || pc == sc) {
                    // Current characters match, so the result depends on the previous state
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' can match zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2]; // Consider zero occurrences of preceding character
                    char prevChar = p.charAt(j - 2);
                    if (prevChar == '.' || prevChar == sc) {
                        // '*' matches one or more occurrences of the preceding character
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        // The result is whether the entire string matches the entire pattern
        return dp[m][n]; 
    }
}