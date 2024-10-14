class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and move towards the first
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // Simply add 1 and return the result
                return digits;
            }
            // If the digit is 9, it becomes 0
            digits[i] = 0;
        }

        // If all digits are 9, we need an extra space at the beginning
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}