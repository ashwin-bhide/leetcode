class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        int i=0, n=s.length();
        int result = 0;
        while(i<n){
            if(i<n-1 && hm.get(s.charAt(i))<hm.get(s.charAt(i+1))){
                result += hm.get(s.charAt(i+1)) - hm.get(s.charAt(i));
                i = i+2;
            } else{
                result += hm.get(s.charAt(i));
                i = i+1;
            }   
        }
        
        return result;
    }
}
