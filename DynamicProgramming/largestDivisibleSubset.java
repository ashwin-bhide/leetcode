class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n==0)
            return new ArrayList();
        Arrays.sort(nums);
        
        int[] dp = new int[n];
        int[] pre = new int[n];
        
        int max = 0;
        int index = 0; //for storing index of element where our max subset ends
        
        for(int i=0;i<n;i++){
            dp[i] = 1; //each number is divisible by itself
            pre[i] = -1; //stores the index of previous longest found subsequence
            
            for(int j=i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0){
                    if(1+dp[j] > dp[i]){
                        dp[i] = 1 + dp[j]; //add 1 to previously found max subset
                        pre[i] = j; //store index of previous largest subset
                    }
                }
            }
            
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        
        List<Integer> result = new ArrayList();
        while(index!=-1){
            result.add(nums[index]);
            index = pre[index];
        }
        
        return result;
    }
}
