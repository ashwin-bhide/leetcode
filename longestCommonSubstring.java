class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using sliding window
        //start left and right at 0
        //while window is unique, move right by 1
        //once duplicate window found, move left by 1(shrink window) and keep on moving right until next duplicate found
        HashSet<Character> hs = new HashSet<>();
        int left=0,right=0,maxLength=0;
        while(left<s.length() && right<s.length()){
            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right));
                maxLength = Math.max(maxLength,right-left+1);
                right++;
            }
            else{
                hs.remove(s.charAt(left++));
            }
        }
        return maxLength;
    }           
}
