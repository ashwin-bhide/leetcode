class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = 1;
        for(int i=1;i<n;i++)
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        
        int rightProduct = 1;
        for(int i=n-2;i>=0;i--){
            rightProduct*=nums[i+1];
            leftProduct[i]*=rightProduct;
        }
        return leftProduct;
    }
}
