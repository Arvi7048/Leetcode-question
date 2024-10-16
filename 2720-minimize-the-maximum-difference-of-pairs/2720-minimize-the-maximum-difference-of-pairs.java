class Solution {
    public int minimizeMax(int[] nums, int p) {
         Arrays.sort(nums); // Step 1: Sort the array to make it easier to find minimum maximum difference

        int left = 0; // Smallest possible maximum difference
        int right = nums[nums.length - 1] - nums[0]; // Largest possible maximum difference

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid; // Try to minimize the maximum difference
            } else {
                left = mid + 1; // Increase the allowed maximum difference
            }
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int pairs = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                pairs++;
                i++; // Skip the next index to ensure no index is reused
            }
            if (pairs >= p) {
                return true; // We've formed enough pairs
            }
        }
        return false;
    }
}