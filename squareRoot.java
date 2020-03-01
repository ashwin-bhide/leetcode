class Solution {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int start = 2, end = x/2, pivot;
        while(start<=end){
            pivot = (start + end) / 2;
            long num = (long)pivot*pivot;
            if(num == x)
                return pivot;
            else if(num>x)
                end = pivot-1;
            else
                start++;
                
        }
        return end;
    }
}
