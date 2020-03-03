/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n==0)
            return -1;
        if(n==1)
            return isBadVersion(1)?1:-1;
        int start = 1, end = n, mid;
        while(start<end){
            mid = start+(end-start)/2;
            if(isBadVersion(mid)){
                end=mid;
            } else
                start = mid+1;
        }
        if(isBadVersion(start)) return start; //pointer points to same element, after start==end condition is reached
        return -1;
    }
}
