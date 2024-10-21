class Solution {
    public boolean isPalindrome(int x) {
          // Negative numbers are not palindromes
        // Also, if the number ends with 0 and is not 0, it's not a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}