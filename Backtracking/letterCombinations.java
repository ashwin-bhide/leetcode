class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits.length()==0)
            return result;
        
        String[] digitMap = new String[]{
            "0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        
        letterCombinationsHelper(result,digitMap,digits,new StringBuilder(),0);
        
        return result;
    }
    private void letterCombinationsHelper(List<String> result,String[] digitMap,String digits,StringBuilder curr,int index){
        //base condition
        if(index==digits.length()){
            result.add(curr.toString());
            return;
        }
        
        int currDigit = digits.charAt(index)-'0';
        char[] letters = digitMap[currDigit].toCharArray();
        
        for(int i=0;i<letters.length;i++){
            //choose
            curr.append(letters[i]);
            //explore
            letterCombinationsHelper(result,digitMap,digits,curr,index+1);
            //unchoose
            curr = new StringBuilder(curr.substring(0,index));
        }
        
    }
}
