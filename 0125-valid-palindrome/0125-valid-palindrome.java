class Solution {
    public boolean isPalindrome(String s) {
         // Step 1: Normalize the string
        StringBuilder filteredStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredStr.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Check if the normalized string is a palindrome
        int left = 0;
        int right = filteredStr.length() - 1;

        while (left < right) {
            if (filteredStr.charAt(left) != filteredStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    
    }
}