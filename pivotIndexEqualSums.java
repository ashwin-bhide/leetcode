class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==0)
            return -1;
        
        int totalSum = 0, leftSum = 0;
        for(int n:nums)
            totalSum += n;
        
        for(int i=0;i<nums.length;i++){
            int rightSumAtCurr = totalSum - nums[i] - leftSum;
            if(leftSum == rightSumAtCurr)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
