class Solution {
    public int myAtoi(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;
        
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Check for the sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits to an integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Step 4: Handle overflow cases
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        // Step 5: Apply the sign and return the result
        return result * sign;
    }
}