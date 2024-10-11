class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;

        // Map to store the frequency of words in the words array
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Iterate over all possible start points within the word length
        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, wordLength, totalWords, totalLength, s, wordCountMap, result);
        }

        return result;
    }

    private void slidingWindow(int start, int wordLength, int totalWords, int totalLength, String s,
                               Map<String, Integer> wordCountMap, List<Integer> result) {
        Map<String, Integer> seenWords = new HashMap<>();
        int left = start;
        int count = 0;

        // Traverse the string from the given start position
        for (int right = start; right <= s.length() - wordLength; right += wordLength) {
            // Extract the current word
            String currentWord = s.substring(right, right + wordLength);

            // If the word is part of words
            if (wordCountMap.containsKey(currentWord)) {
                seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                count++;

                // If we have seen the word too many times, move the left pointer
                while (seenWords.get(currentWord) > wordCountMap.get(currentWord)) {
                    String leftWord = s.substring(left, left + wordLength);
                    seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                    count--;
                    left += wordLength;
                }

                // If we have seen exactly totalWords words, we found a valid start
                if (count == totalWords) {
                    result.add(left);
                }
            } else {
                // Reset if we encounter a word not in words
                seenWords.clear();
                count = 0;
                left = right + wordLength;
            }
        }
    }
}