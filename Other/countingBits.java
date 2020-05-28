class Solution {
    public int[] countBits(int num) {
        //binary representation of even number has 0 as LSB
        //binary representation of odd number has 1 as LSB
        //dividing an integer x is equivalent to right shift of its binary representaion, where we get rid of LSB
        int[] result = new int[num+1];
        result[0] = 0;
        
        for(int i=1;i<=num;i++){
            if(i%2==0) //if number is even
                result[i] = result[i/2]; 
            else
                result[i] = 1+result[i/2];
        }
        
        return result;
    }
}
