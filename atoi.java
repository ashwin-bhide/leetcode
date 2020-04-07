class Solution {
    public int myAtoi(String str) {
        if(str==null)
            return 0;
        str = str.trim();
        if(str.length()==0)
            return 0;
        
        char[] ch = str.toCharArray();
        String number = "";
        boolean continueChecking = true;
        
        char c = ch[0];
        if(c=='+' || c=='-' || Character.isDigit(c))
            number+=c;
        else 
            return 0;
        
        for(int i=1;i<ch.length;i++){
            if(continueChecking && Character.isDigit(ch[i])){
                number += ch[i];
            } else {
                continueChecking = false;
                break;
            }      
        }
        
        if(number.equals("") || number.equals("+") || number.equals("-"))
            return 0;
        
        int answer;
        try{
            answer = Integer.parseInt(number);
        } catch(Exception e){
            if(number.charAt(0)=='-')
                answer = Integer.MIN_VALUE; 
            else 
                answer = Integer.MAX_VALUE; //if first character is + or digit
        }
        
        return answer;
        
    }
}
