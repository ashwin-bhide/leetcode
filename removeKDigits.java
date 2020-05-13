class Solution {
    //greedy method for solving this problem
    //go from left to right, removing items in following way
    //425, remove 4, so if current number is less than number on left, remove left number
    //we use stack to maintain number on left
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque();
        for(char c:num.toCharArray()){
            while(stack.size()>0 && k>0 && c<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        //if the current numbers in stack are in increasing sequence, and k is still not zero, remove last elements of stack; eg. 123456 and k=2, remove 56
        for(int i=0;i<k;i++)
            stack.pop();
        
        StringBuilder res = new StringBuilder();
        //create new string by removing leading zeros if present
        boolean leadingZero = true;
        while(!stack.isEmpty()){
            char c = stack.pollLast(); //since we are using stack, when we form string, we need to start from bottom of stack
            if(c=='0' && leadingZero)
                continue;
            leadingZero = false;
            res.append(c);
        }
        
        String result = res.toString();
        
        return (result.length()==0)?"0":result;
        
    }
}
