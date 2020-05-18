class Solution {
    public String countAndSay(int n) {
        String sequence = "1";
        
        for(int i=0;i<n-1;i++){
            StringBuilder ir = new StringBuilder(); //intermediate sequence
            char[] ch = sequence.toCharArray(); //previous sequence
            int j=0;
            while(j<ch.length){
                int count = 1;
                while(j+1<ch.length && ch[j]==ch[j+1]){  //count consecutive characters, eg. if 11, then count=2 and value=1
                    count++;
                    j++;
                }
                ir.append(count).append(ch[j++]); //so we have intermediate sequence as 21
            }
            sequence = ir.toString();
        }
        return sequence;
    }
}
