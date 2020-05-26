class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length<=1)
            return 0; //length should atleast be 2
        
        //we maintain count variable, +1 for each 1 encountered and -1 for each 0 encountered
        int count = 0;
        //we maintain Map for count at current index location
        Map<Integer,Integer> hm = new HashMap();
        int result = 0;
        
        for(int i=0;i<nums.length;i++){
            count += (nums[i]==1)?1:-1;
            if(count==0)
                result = Math.max(result,i+1); //as it is zero based, length will be +1
            else{
                //if same count occurs twice, then length is current index - last time same count occured
                if(hm.containsKey(count))
                    result = Math.max(result,i-hm.get(count));
                else //we only maintain index of first occurence of count in hm
                    hm.put(count,i);
            }
        }
        return result;
    }
}
