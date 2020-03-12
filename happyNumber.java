class Solution {
    public boolean isHappy(int n) {
        if(n==0)
            return false;
        HashSet<Integer> hs = new HashSet<>();
        int res = getSumOfSquares(n);
        while(true){
            if(res == 1)
                return true;
            if(hs.contains(res))
                return false;
            else
                hs.add(res);
            res = getSumOfSquares(res);
        }
        
    }
    public int getSumOfSquares(int num){
        int sum = 0, digit = 0;
        while(num>0){
            digit = num%10;
            sum+= digit*digit;
            num = num/10;
        }
        return sum;
    }
}
