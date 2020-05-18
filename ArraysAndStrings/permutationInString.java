class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        if(s1len==0 || s2len==0 || s2len<s1len)
            return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(char c:s1.toCharArray())  //count of chars in s1
            s1Count[c-'a']++;
        
        int left = 0, right = 0;
        while(right<s2len){
            char curr = s2.charAt(right);  //sliding window, initially left=right=0
            s2Count[curr-'a']++;                   //we maintain count of chars in current window in s2Count
            if(Arrays.equals(s1Count,s2Count))
                return true;
            if(right-left==s1len-1){
                left++;
                s2Count[s2.charAt(right-(s1len-1)) - 'a']--; //find index of element to remove ie shrink from left
            }
            right++;
        }
        return false;
    }
}
