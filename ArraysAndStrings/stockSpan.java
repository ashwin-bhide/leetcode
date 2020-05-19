class StockSpanner {
    //stock span simple meaning: stock A closed on a 4 day high, ie stock price was highest since past 4 days(including today)
    //we'll use a stack to maintain the stock price & day number
    public class StackNode{
        int price;
        int day;
    }
    int currDay; //global variable to maintain the day number
    Deque<StackNode> stack;
    public StockSpanner() {
        stack = new ArrayDeque<StackNode>();
        currDay = -1; 
    }
    
    public int next(int price) {
        currDay++;
        StackNode currNode = new StackNode();
        currNode.price = price;
        currNode.day = currDay;
        
        while(!stack.isEmpty() && stack.peek().price<=currNode.price) //find the peak to the left of the current element
            stack.pop();
        
        int result = 0;
        if(stack.isEmpty()){ //all elements prior to current stock, are smaller than current value
            result = currNode.day+1;
        } else
            result = currNode.day-stack.peek().day;
        
        stack.push(currNode);
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
