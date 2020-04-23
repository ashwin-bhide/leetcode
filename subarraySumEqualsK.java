class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0)
            return 0;   
        
        //given that sum[i], sum of numbers from 0th index until ith index
        // sum[j]-sum[i] gives us the sum of numbers between i and j
        // if that equals k, it means that that subarray between i and j (j inclusive) has sum equal to k
        Map<Integer,Integer> hm = new HashMap();
        int cumulativeSum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            cumulativeSum += nums[i];
            if(cumulativeSum==k)
                count++;
            if(hm.containsKey(cumulativeSum-k)) //find if any sum (without k/subtracting k) has been found before; if it has, indicates that sum of numbers after that sum until now, equals k
                count += hm.get(cumulativeSum-k);
            hm.put(cumulativeSum,hm.getOrDefault(cumulativeSum,0)+1); //maintain map of sum at each index, with value as the count no. of times it has been found
        }
        return count;
    }
}
