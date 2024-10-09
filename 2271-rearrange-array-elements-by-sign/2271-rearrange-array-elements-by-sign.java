class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int posind = 0, negind =1;
        for(int i= 0; i<n; i++){
            if(nums[i]<0){
                ans[negind] = nums[i];
                negind+=2;
            }
            else{
                ans[posind] = nums[i];
                posind+=2;
            }
        }
        return ans;
    }
}