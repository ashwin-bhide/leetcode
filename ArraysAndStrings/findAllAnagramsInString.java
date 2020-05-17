class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        
        int slen = s.length();
        int plen = p.length();
        
        if(slen==0 || plen==0 || slen<plen)
            return result;
        
        int[] scount = new int[26]; //count of char in current working window
        int[] pcount = new int[26]; //count of char in p (target string)
        
        for(char c:p.toCharArray()){
            pcount[c-'a']++;
        }
        
        int left = 0, right = 0;
        while(right<slen){
            boolean isFound = false;
            scount[s.charAt(right)-'a']++; //expand window to right
            if(Arrays.equals(scount,pcount)){
                //shrink window from left
                //add to result
                isFound = true;
                result.add(left);
                scount[s.charAt(left)-'a']--;
                left++;
            }
            if(!isFound && right-left==plen-1){
                scount[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        
        return result;
    }
}
