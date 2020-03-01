class Solution {
    int target;
    int[] nums;
    public int search(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        return helperSearch(0,nums.length-1);
    }
    public int helperSearch(int start,int end){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]<target)
            return helperSearch(mid+1,end);
        else
            return helperSearch(start,mid-1);
    }
}
