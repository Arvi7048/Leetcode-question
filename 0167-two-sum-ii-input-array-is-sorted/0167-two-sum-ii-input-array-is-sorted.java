class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // Return the indices as 1-indexed
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                // Increase the sum by moving the left pointer to the right
                left++;
            } else {
                // Decrease the sum by moving the right pointer to the left
                right--;
            }
        }
        
        // If no solution found (though there is guaranteed to be one)
        return new int[] {-1, -1};
    }
}