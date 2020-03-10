class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        //walk through problem by creating result array of same size and store current maximum sum upto that index in array
        int maxSum, currSum;
        currSum = maxSum= nums[0];
        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }
}
