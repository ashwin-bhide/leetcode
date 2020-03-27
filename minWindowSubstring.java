class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)
            return "";
        
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> formedMap = new HashMap<>();
        
        for(int i=0;i<t.length();i++)
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        
        int[] result = new int[]{-1,0,0}; //length, start, end
        
        int formed = 0, required = tMap.size(); //number of unique characters required to fulfill target string
        int left=0, right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            formedMap.put(c,formedMap.getOrDefault(c,0)+1);
            //if count of character in target matches count of current window 
            if(tMap.containsKey(c) && tMap.get(c).intValue()==formedMap.get(c).intValue())
                formed++;
            
            //check if t is achieved in current window, if yes, then try contracting the window
            while(left<=right && formed==required){
                int currWindowLen  = right-left+1;
                if(result[0]==-1 || currWindowLen < result[0]){
                    result[0] = currWindowLen;
                    result[1] = left;
                    result[2] = right;
                }
                c = s.charAt(left);
                formedMap.put(c,formedMap.getOrDefault(c,0)-1); //decrement char at left from windowMap
                if(tMap.containsKey(c) && formedMap.get(c).intValue()<tMap.get(c).intValue()) //shrinking window no longer matches target
                    formed--;
                
                left++;
            }
            
            right++; //keep on expanding
        }
        
        return result[0]==-1?"":s.substring(result[1],result[2]+1);
       
    }
}
