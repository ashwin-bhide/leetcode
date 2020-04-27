class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0)
            return false;
        
        //create dp memo/dp table
        //0 = unknown, 1 = good, -1 = bad
        int[] memo = new int[nums.length];
        for(int i=0;i<memo.length;i++)
            memo[i] = 0;
        memo[memo.length-1] = 1; //last element is always good, as we can reach it from itself
        return canJumpHelper(0,nums,memo);
        
    }
    
    private boolean canJumpHelper(int index,int[] nums, int[] memo){
        //if memo at current position is not unknown, return whether good/bad
        if(memo[index]!=0){
            return (memo[index]==1)?true:false;
        }
        
        int maxSteps = Math.min(nums[index],nums.length-1-index); //ensures we don't exceed length of nums while jumpimg
        if(maxSteps==0) return false;
        for(int i=maxSteps;i>=1;i--){
            if(canJumpHelper(index+i,nums,memo)){
                memo[index] = 1; //mark position as good
                return true;
            }
        }
        memo[index] = -1;  //mark  position as bad
        return false;
    } 
    //backtracking solution
//     private boolean canJumpHelper(int index,int[] nums){
//         //base case
//         if(index>=nums.length-1)
//             return true;
        
//         int maxSteps = nums[index];
//         if(maxSteps == 0)
//             return false;
        
//         for(int i=maxSteps;i>=1;i--){
//             if(canJumpHelper(index+i,nums))
//                 return true;
//         }
        
//         return false;
//     }
    
}
