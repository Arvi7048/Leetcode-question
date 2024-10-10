class Solution {
    public void nextPermutation(int[] nums) {
       
        // Convert int[] to List<Integer>
        List<Integer> A = new ArrayList<>();
        for (int num : nums) {
            A.add(num);
        }

        int n = A.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            // Copy back to nums
            for (int i = 0; i < n; i++) {
                nums[i] = A.get(i);
            }
            return;
        }

        // Step 2: Find the next greater element
        // and swap it with A[ind]:
        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // Step 3: Reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        // Copy the updated list back to nums
        for (int i = 0; i < n; i++) {
            nums[i] = A.get(i);
        }
    
    }

}