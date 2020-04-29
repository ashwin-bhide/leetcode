class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0)
            return -1;
        
        Set<String> operators = new HashSet();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<Integer> s = new Stack();
        for(String t:tokens){
            if(!operators.contains(t)){
                s.push(Integer.parseInt(t));
            } else{
                int op2 = s.pop();
                int op1 = s.pop();
                switch(t){
                    case "+": s.push(op1+op2);
                                break;
                    case "-": s.push(op1-op2);
                                break;
                    case "*": s.push(op1*op2);
                                break;
                    case "/": s.push(op1/op2);
                                break;
                }
            }
        }
        return s.pop();
    }
}
