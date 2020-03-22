class Solution {
    public int trap(int[] height) {
        // we start from left and right
        // we are interested in only the minimum of the the 2, because that is the threshhold upto which water can be stored
        // once above step is identified, we move pointer; if next element is smaller, we calculate difference between lmax/rmax and current element and move ahead
        //because we now that water will be stored at that location, as already one of our pointers on either side has been identified as taller
        int lptr = 0, rptr = height.length-1;
        int lmax=0, rmax = 0, result = 0;
        while(lptr<rptr){
            if(height[lptr]<height[rptr]){
                if(height[lptr]>=lmax)
                    lmax = height[lptr];
                else
                    result+= lmax - height[lptr];
                lptr++;
            } else{
                if(height[rptr]>=rmax)
                    rmax = height[rptr];
                else
                    result+= rmax - height[rptr];
                rptr--;
            }
        }
        return result;
    }
}
