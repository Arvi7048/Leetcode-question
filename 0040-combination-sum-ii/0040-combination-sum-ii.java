class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination,int[] candidates, int target, int startIndex) {
        // Base case: if the current combination sums to the target
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        // If the target is less than 0, no valid combination can be formed
        if (target < 0) {
            return;
        }
        
        // Explore further with each candidate starting from startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            // Skip duplicates
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue; // Skip the same element to avoid duplicates
            }
            // Include candidates[i] in the combination
            currentCombination.add(candidates[i]);
            // Move to the next candidate
            backtrack(result, currentCombination, candidates, target - candidates[i], i + 1);
            // Backtrack, remove the last added candidate
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
