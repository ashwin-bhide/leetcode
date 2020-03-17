class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        
        generateBalancedParanthesis(n,n,"",result);
        return result;
    }
    public void generateBalancedParanthesis(int openCount, int closeCount, String paranInProgress,List<String> result){
        if(openCount==0 && closeCount==0)
            result.add(paranInProgress);
        
        if(openCount>0)
            generateBalancedParanthesis(openCount-1,closeCount,paranInProgress+"(",result);
        
        if(openCount<closeCount)
            generateBalancedParanthesis(openCount,closeCount-1,paranInProgress+")",result);
    }
}
