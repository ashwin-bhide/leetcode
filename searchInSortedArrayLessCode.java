class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while(start<=end){
            mid = (start+end)/2;
            if(target==nums[mid])
                return mid;
            
            if(nums[mid]>=nums[start]){ // array to left of mid is non-rotated; >= used instead of > to handle condition when array size is 2, eg.[3,1]
                //search target in non-rotated(left-side), ascending order array
                if(target>=nums[start] && target<nums[mid]) 
                    end = mid-1;
                else
                    start = mid+1;
            } else{ //array to right of mid is non-rotated
                //search target in non-rotated(right-side), ascending order array
                if(target>nums[mid] && target<=nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
}
