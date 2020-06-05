class Solution {
    //probabilty question
    //higher the weight, greater is the probability of picking the index corresponding to that weight
    int[] cum_sum; //stores cumulative sum upto current index
    int sum;
    public Solution(int[] w) {
        sum = 0;
        cum_sum = new int[w.length];
        for(int i=0;i<w.length;i++){
            sum += w[i];
            cum_sum[i] = sum;
        }
        //finally sum will have total of all weights in given array
    }
    
    public int pickIndex() {
        int val = (int)(Math.random() * sum);
        return binarySearch(val+1);
    }
    //returns index of val
    private int binarySearch(int val){
        int l = 0, h = cum_sum.length-1;
        while(l<h){
            int mid = l + (h-l)/2;
            if(val > cum_sum[mid])
                l = mid+1;
            else
                h = mid;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
