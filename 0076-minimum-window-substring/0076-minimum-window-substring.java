class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        // Variables for sliding window
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int required = tFreqMap.size(); // number of unique characters we need to match
        int formed = 0; // number of unique characters currently matching

        // Frequency map for characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            // Add character from the right end of the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if this character is needed and if we have matched the required frequency
            if (tFreqMap.containsKey(c) && windowCounts.get(c).intValue() == tFreqMap.get(c).intValue()) {
                formed++;
            }

            // Contract the window till it ceases to be 'valid'
            while (left <= right && formed == required) {
                // Update the minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove the character at the left pointer
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                
                if (tFreqMap.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < tFreqMap.get(leftChar).intValue()) {
                    formed--;
                }

                // Move the left pointer forward
                left++;
            }

            // Expand the window by moving right pointer
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
     
    }
}