class Solution {
    public int romanToInt(String s) {
           int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // If the current value is less than the next value, subtract it
            if (i < n - 1 && romanToValue(s.charAt(i)) < romanToValue(s.charAt(i + 1))) {
                total -= romanToValue(s.charAt(i));
            } else {
                total += romanToValue(s.charAt(i));
            }
        }

        return total;
    }
      private static int romanToValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}