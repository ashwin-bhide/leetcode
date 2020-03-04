//this solution considers rising edge and falling edge, if plotted on graph
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1])      //then nums[mid] is peak or element to its left is peak
                end = mid;
            else
                start = mid+1;     //since nums[mid] is smaller than next, peak must be on right
        }
        //loop terminates when start==end
        return start;
    }
}
