class Solution {
    public int[] productExceptSelf(int[] nums) {
        //consider it as product of left(0 to i-1) * product of right(i+1 to length-1)
        //in first pass we calculate product of numbers to left of index
        //in second pass, we start from second last element of array(As last element is already computed in first pass, and multiply by product on right, stored in R )
        int length = nums.length;
        int[] answer = new int[length];
        answer[0]=1;
        for(int i=1;i<length;++i)
            answer[i]=answer[i-1]*nums[i-1];
        
        int R=1;
        for(int i=length-2;i>=0;i--){
            R*=nums[i+1];
            answer[i]*=R;
        }
        return answer;
    }
}
