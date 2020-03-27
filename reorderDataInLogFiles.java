class Solution {
    public class LogComparator implements Comparator<String>{
        public int compare(String a, String b){
            String[] as = a.split(" ",2);
            String[] bs = b.split(" ",2);
            int i = as[1].compareTo(bs[1]);
            
            if(i==0){//first letter of both logs is same, check identifier
                return as[0].compareTo(bs[0]);                                  
            }
            return i;
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        
        for(String log:logs){
            String[] wordsInLog = log.split(" ",2);
            if(Character.isDigit(wordsInLog[1].charAt(0)))
                digitLogs.add(log);
            else
                letterLogs.add(log);
        }
        Collections.sort(letterLogs,new LogComparator());
        letterLogs.addAll(digitLogs);
        
        return letterLogs.toArray(new String[0]);
        
    }
}
