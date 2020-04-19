class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        
        int[] dp = new int[nums.length]; 
        for(int i=0;i<nums.length;i++)
            dp[i] = 1;                  //initialise dp array
        int max = 1;
        
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    int l = dp[j]+1;
                    dp[i] = Math.max(l,dp[i]);
                    if(max<dp[i])
                        max = dp[i];
                }
            }
        }
        return max;
    }
}
