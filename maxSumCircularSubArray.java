class Solution {
    //2 cases
    //case 1 : maxSubArray sum is in the middle
    //eg: 1,2,5,6,-10 : maxSum = 2+5+6 = 13 can be solved using Kadane's Algorithm
    //case 2: maxSubArray is split across the circular array
    //eg: 5,2,-1,-3,7: maxSum = 7+5+2 = 14
    //Here, consider array is split in 3 parts- [5,2] [-1,-3] and [7]. Our answer is totalArraySum - sum[-1,-3]
    //so, we need to find minSubArraySum and then subtract it form totalArraySum
    public int maxSubarraySumCircular(int[] A) {
        if(A.length==1)
            return A[0];
        
        //calculate maxSum for usual non-circular array using Kadane's algorithm
        int nonCircularSum = kadaneMaxSum(A);
        
        //now calculate for case when subArray is wrapped around (case 2)
        int totalArraySum = 0;
        for(int i=0;i<A.length;i++){
            totalArraySum += A[i];
            A[i] = -A[i];
        }
        
        int minSum = -kadaneMaxSum(A);
        int circularSum = totalArraySum - minSum;
        return (circularSum==0)?nonCircularSum:Math.max(nonCircularSum,circularSum);
        
    }
    private int kadaneMaxSum(int[] arr){
        int maxSum = -Integer.MAX_VALUE;
        int currSum = 0;
        for(int i=0;i<arr.length;i++){
            currSum = arr[i] + Math.max(currSum,0);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
