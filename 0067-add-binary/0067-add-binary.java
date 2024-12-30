class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop through both strings from the end to the start
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Add the current bit from string a
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Add the current bit from string b
                j--;
            }

            carry = sum / 2; // Calculate carry for the next iteration
            result.append(sum % 2); // Append the current bit to the result
        }

        return result.reverse().toString();
        
    }
}