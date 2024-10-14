class Solution {
    public String minWindow(String s, String t) {
         if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        int required = tFreqMap.size(); // Number of unique characters we need to match
        int left = 0, right = 0, formed = 0;
        int[] result = {-1, 0, 0}; // {window length, left, right}
        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            // Expand window by adding the character at the right
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tFreqMap.containsKey(c) && windowCounts.get(c).equals(tFreqMap.get(c))) {
                formed++;
            }

            // Contract the window until it stops being valid
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                // Update the result if this window is smaller
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                // Remove character at left pointer from window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tFreqMap.containsKey(c) && windowCounts.get(c) < tFreqMap.get(c)) {
                    formed--;
                }

                // Move left pointer to shrink the window
                left++;
            }

            // Expand the window
            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}