class Solution {
    public String countAndSay(int n) {
         if (n == 1) {
            return "1"; // Base case
        }
        
        String currentTerm = "1"; // Start with the first term
        for (int i = 2; i <= n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            char[] chars = currentTerm.toCharArray();
            int count = 1;

            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == chars[j - 1]) {
                    count++; // Increase count if the same digit continues
                } else {
                    nextTerm.append(count).append(chars[j - 1]); // Append count and digit
                    count = 1; // Reset count for the new digit
                }
            }
            // Append the last counted digit
            nextTerm.append(count).append(chars[chars.length - 1]);
            currentTerm = nextTerm.toString(); // Move to the next term
        }

        return currentTerm;
    }
}