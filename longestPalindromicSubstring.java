class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";
        
        int start = 0, end = 0; //start and end indices of result string
        for(int i=0;i<s.length();i++){ //traverse through string
            int length1 = expandAroundCenter(s,i,i); ////odd s.length() case
            int length2 = expandAroundCenter(s,i,i+1);  //even s.length() case
            int length = Math.max(length1,length2);
            if(length>(end-start)){ //length is greater than maximum length till now
                start = i - (length-1)/2; //to handle even case, otherwise array index out of bound, might reach start = -1
                end = i + (length)/2; 
            }
        }
        return s.substring(start,end+1); //substring function has end index exclusive
    }
    //check if character on left and right of given index matches(is palindrome), if not return with length of string
    public int expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;  //when condition in while is not satisfied, left will be -1 than we want and right will be +1 than we want, so we take the difference (r-l) and subtract 1
    }
}
