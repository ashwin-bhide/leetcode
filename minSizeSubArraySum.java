class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int minCount = Integer.MAX_VALUE;
        int start = 0,sum=0;
        if(nums==null || length==0)
            return 0;
        //right - end index when condition is reached
        for(int right=start;right<length;right++){
            sum+=nums[right];
            while(sum>=s){
              minCount=Math.min(minCount,right-start+1);//difference between start and right gives count
              sum-=nums[start++];
            }
        }
        return (minCount!=Integer.MAX_VALUE)?minCount:0;
    }
}
