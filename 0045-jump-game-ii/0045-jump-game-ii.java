class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0; // No need to jump if there's only one element
        }

        int jumps = 0; // Number of jumps made
        int currentEnd = 0; // The farthest index we can reach with the current jump
        int farthest = 0; // The farthest index we can reach in the next jump

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update farthest reachable index

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++; // Make a jump
                currentEnd = farthest; // Update the current end to the farthest reachable index

                // If we've already reached or passed the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}