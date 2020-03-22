class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //makes sure that first array(x) is always smaller in length
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        
        int x = nums1.length;
        int y = nums2.length;
        double result = -1;
        
        int start = 0;
        int end = x;
        
        while(start<=end){  //our range of inspection is the smaller array(x), we find partition point in this array
            int partitionX = (start+end)/2;
            int partitionY = (x+y+1)/2 - partitionX;
        
            int maxLeftX = (partitionX==0)?Integer.MIN_VALUE:nums1[partitionX-1];
            int minRightX = (partitionX==x)?Integer.MAX_VALUE:nums1[partitionX];
            
            int maxLeftY = (partitionY==0)?Integer.MIN_VALUE:nums2[partitionY-1];
            int minRightY = (partitionY==y)?Integer.MAX_VALUE:nums2[partitionY];
        
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if((x+y)%2==0){
                    result = (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
                    break;
                }
                else{
                    result = (double)Math.max(maxLeftX,maxLeftY);
                    break;
                }
            } else if(maxLeftX>minRightY) //we need to move to the left
                    end = partitionX-1;
                else
                    start = partitionX+1; // we need to move to right
        }
        return result;
    }
}
