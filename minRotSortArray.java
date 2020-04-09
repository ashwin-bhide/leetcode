class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        int start = 0, end = nums.length-1, mid=0;
        
        if(nums[start]<nums[end])
            return nums[0];
        
        while(start<=end){
            mid = start + (end-start)/2;
            
            if(nums[mid] > nums[mid+1]) //breaks the ascending flow, so this is deflection point
                return nums[mid+1];
            
            if(nums[mid-1] > nums[mid]) 
                return nums[mid];
            
            if(nums[start]<nums[mid]){  //array to right is unsorted
                start = mid+1;
            } else if(nums[start]>nums[mid]){ //array to left is unsorted
                end = mid-1;
            }
        }
        return -1;
    }
}
