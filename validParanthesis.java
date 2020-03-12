class Solution {
    public boolean isValid(String s) {
        if(s==null || s=="")
            return true;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(')');
            else if(s.charAt(i)=='{')
                st.push(('}'));
            else if(s.charAt(i)=='[')
                st.push(']');
            else if(st.isEmpty() || s.charAt(i)!=st.pop())
                return false;
        }
        return st.isEmpty();
    }
}
