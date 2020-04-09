class Solution {
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int low=0, curr=0, high = nums.length-1;
        while(curr<=high){
            switch(nums[curr]){
                case 0: swap(nums,low,curr);
                        low++;curr++;
                        break;
                case 1: curr++;
                        break;
                case 2: swap(nums,curr,high);
                        high--;
                        break;
            }
        }
        
    }
}
