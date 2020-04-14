class Solution {
    private static String doShift(String s, int finalShift){
        if(finalShift==0)
            return s;
        char[] cs = s.toCharArray();
        
        int left = 0, right = cs.length-1;
        int scount = Math.abs(finalShift);
        scount = scount%cs.length; //if string of length=3 is rotated 3 times, we get same string
        char t;
        
        if(finalShift>0){
            for(int k=0;k<scount;k++){
                //shift right by 1
                t = cs[right];
                for(int i=right;i>0;i--){
                    cs[i] = cs[i-1];
                }
                cs[left] = t;
            }
        } else{
            for(int k=0;k<scount;k++){
                //shift left by 1
                t = cs[left];
                for(int i=0;i<right;i++){
                    cs[i] = cs[i+1];
                }
                cs[right] = t;
            }
        }
        return new String(cs);    
        
    }
    public String stringShift(String s, int[][] shift) {
        if(s.length()==0 || shift.length==0)
            return s;
        
        int finalShift = 0;
        for(int[] sh:shift){
            if(sh[0]==0)
                finalShift += (-1)*sh[1]; //shift left count
            else
                finalShift += sh[1]; //shift right
        }
        
        return doShift(s,finalShift);
        
        
    }
}
