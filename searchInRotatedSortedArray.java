class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length;
        if(size==0)
            return -1;
        if(size==1)
            return target==nums[0]?0:-1;
        int pivotIndex = findPivot(nums);
        
        if(pivotIndex==-1)
            return binarySearch(nums,0,size-1,target);
        
        if(target==nums[pivotIndex])
            return pivotIndex;
        else if(target<nums[0])
            return binarySearch(nums,pivotIndex+1,size-1,target);
        else
            return binarySearch(nums,0,pivotIndex-1,target);
    }
    public int findPivot(int[] nums){
        int start = 0, end = nums.length-1, pivot;
        if(nums[start]<nums[end])
            return -1;
        while(start<=end){
            pivot = (start+end)/2;
            //indicates that sorted order of array has been broken, so next element is the smallest element and its position is returned as pivot
            if(nums[pivot]>nums[pivot+1]) 
                return pivot+1;
            else{
                //indicates pivot is to left of pivot element, as in sorted array start element should                    have been smaller
                //*** Order of below operation is very important**********
                if(nums[pivot]<nums[start])
                    end = pivot-1;
                else
                    start = pivot+1; //answer is to the right side portion of pivot element
            }     
        }
        return -1; //indicates array has not been rotated
    }
    //binarySearch is called only in case of sorted array, returns -1 if target not found
    public int binarySearch(int[] nums,int start,int end,int target){
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(target==nums[mid]) 
                return mid;
            else if(target>nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
