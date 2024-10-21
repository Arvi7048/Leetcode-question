class Solution {
    public int removeElement(int[] nums, int val) {
         int j = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is not equal to val, place it at index j
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        
        // Return the count of elements not equal to val
        return j; 
    }
}