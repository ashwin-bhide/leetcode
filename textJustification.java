class Solution { //we will employ greedy approach to solve this problem
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();
        int start = 0; //represents index in words array; first word of line 
        //while ends when we exhaust all given words
        while(start<words.length){
            //for each line, we find the start and the end word on that line such that it satisfies maxWidth
            int end = findEndWord(words,start,maxWidth);
            //now we justify the line; ie add spaces as required
            result.add(justify(words,start,end,maxWidth));
            //one line is done, move to next words in string
            start = end+1;
        }
        return result;
    }
    private int findEndWord(String[] words,int start,int maxWidth){
        maxWidth -= words[start++].length();
        while(start<words.length && 1+words[start].length()<=maxWidth){
            maxWidth -= (1 + words[start++].length());
        }
        return start-1; //as loop ends when we overshoot maxWidth or given list of words
    }
    private String justify(String[] words,int start,int end, int maxWidth){
        boolean isLastLine = false;
        if(end == words.length-1)
            isLastLine = true; //if we are at last line, no extra space is inserted between words
        
        if(start==end) //if just 1 word fits on line
            return padRight(words[start],maxWidth);
        
        int numSpacesBetweenWords = end - start; //# single space between words
        int wordsCharLength = getWordsCharLength(words,start,end);
        int remSpaces = maxWidth - wordsCharLength;
        
        String totalSpacesBetweenWords = (isLastLine)?" ":spacesString(remSpaces/numSpacesBetweenWords);
        int extraSpaces = (isLastLine)?0:remSpaces%numSpacesBetweenWords;
        
        StringBuilder sb = new StringBuilder();
        
        int i;
        for(i=start;i<end;i++){
               sb.append(words[i])
               .append(totalSpacesBetweenWords)
               .append(extraSpaces-->0?" ":""); //if greater than 0, then add space, and decrement counter, else don't add space
        }
        sb.append(words[i]);
        
        String result = sb.toString();
        return (isLastLine)?padRight(result,maxWidth):result;
        
    }
    private int getWordsCharLength(String[] words,int start,int end){
        int res = 0;
        for(int i=start;i<=end;i++)
            res+=words[i].length();
        return res;
    }
    private String spacesString(int numberOfSpaces){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<numberOfSpaces;i++)
            res.append(" ");
        return res.toString();
    }
    private String padRight(String word,int maxWidth){
        return word+spacesString(maxWidth-word.length());
    }
}
