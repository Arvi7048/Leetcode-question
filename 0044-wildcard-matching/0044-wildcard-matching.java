class Solution {
    public boolean isMatch(String s, String p) {
         int sLen = s.length(), pLen = p.length();
        int sIndex = 0, pIndex = 0;
        int starIndex = -1, matchIndex = -1;

        while (sIndex < sLen) {
            // If characters match or pattern has '?', move both pointers
            if (pIndex < pLen && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            }
            // If pattern contains '*', record its position and move pattern pointer
            else if (pIndex < pLen && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            }
            // If last pattern pointer was '*', adjust the match and string pointers
            else if (starIndex != -1) {
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            }
            // No match found
            else {
                return false;
            }
        }

        // Check for remaining characters in the pattern, they must all be '*'
        while (pIndex < pLen && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == pLen;
    }
}