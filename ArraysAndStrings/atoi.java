class Solution {
    public int myAtoi(String str) {
        if(str.length()==0)
            return 0;
        
        char[] ch = str.toCharArray();
        StringBuilder resultString = new StringBuilder();
        boolean isSign = false;
        int i=0;
        
        //find first non-space character
        while(i<str.length() && ch[i]==' '){
                i++;
        }
        if(i==str.length())
            return 0;
        //check if first character is '+' or '-' or '[0-9]'
        char c = ch[i];
        if(!Character.isDigit(c)){
            if(ch[i]=='+' || ch[i]=='-')
                isSign = true;
            else
                return 0;
       }
       resultString.append(ch[i++]);
        
        //construct string by only adding digits
        while(i<str.length()){
            if(Character.isDigit(ch[i]))
                resultString.append(ch[i++]);
            else
                break;   
        }
        if(resultString.length()==1 && isSign)
            return 0; //case where string is like +abc
        
        int result=0;
        try{
            result = Integer.parseInt(resultString.toString());   
        } catch(Exception exp){
            if(resultString.toString().charAt(0)=='-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        
        return result;
        
    }
}
