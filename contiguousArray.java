class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length<=1)
            return 0;
        int maxLen = 0, sum = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum += (nums[i]==1)?1:-1;
            if(sum==0)    //no need to put in map if count==0
                maxLen = Math.max(maxLen,i+1);
            if(hm.containsKey(sum))
                maxLen = Math.max(maxLen,i-hm.get(sum));
            else
                hm.put(sum,i);
            
        }
        return maxLen;
    }
}
