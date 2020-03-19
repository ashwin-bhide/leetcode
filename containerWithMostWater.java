class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, area;
        int l=0,r = height.length-1;
        while(l<r){
            area = (r-l)*Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea,area);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
