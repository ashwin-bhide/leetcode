class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==1)
            return 1;
        
        int n = nums.length;
        int[] dp = new int[n];
        
        int max = 0;
        //find longest increasing subsequence at the ith index
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],1+dp[j]);
            }
            max = Math.max(max,dp[i]);
        }
        
        return max;
    }
}
