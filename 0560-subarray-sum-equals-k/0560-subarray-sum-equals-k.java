class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap();
        int pre = 0, cnt = 0;
        mpp.put(0,1);//setting 0 in map
        for(int i = 0;i < n; i++){
            pre+=nums[i];
            //calculate n-k;
            int remove = pre-k;
            //add no of numbers of subarray to be removed 
            cnt += mpp.getOrDefault(remove,0);

            mpp.put(pre,mpp.getOrDefault(pre,0)+1);
        }
        return cnt;
    }
}