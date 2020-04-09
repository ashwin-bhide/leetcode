class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S.length()==0 && T.length()==0)
            return true;
        
        int i = S.length()-1;
        int j = T.length()-1;
        
        int sSkip = 0, tSkip = 0;
        
        while(i>=0 || j>=0){
            while(i>=0){ // we start from end, and reach at index after applying backspaces if they exist
                if(S.charAt(i)=='#'){
                    sSkip++; i--;
                } else if(sSkip>0){
                    sSkip--; i--;
                } else
                    break; //starting from reverse, if first char encountered is non-#, then stop at that index
            }
            while(j>=0){
                if(T.charAt(j)=='#'){
                    tSkip++; j--;
                } else if(tSkip>0){
                    tSkip--; j--;
                } else
                    break;
            }
            
            if((i>=0) != (j>=0))  //if if we have exhausted either strings, then 1 string has nothing to compare with other 
                return false;
            
            if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j))
                return false; //chars are not equal
            
            i--;j--;
        }
        return true;
        
    }
}
