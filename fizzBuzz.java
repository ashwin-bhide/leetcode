class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        LinkedHashMap<Integer,String> lhm = new LinkedHashMap<Integer,String>();
        lhm.put(3,"Fizz");
        lhm.put(5,"Buzz");
        
        for(int i=1;i<=n;i++){
            String res = "";
            
            for(Integer key:lhm.keySet()){
                if(i%key==0)
                    res+=lhm.get(key);
            }
            
            if(res.equals(""))
                res+=Integer.toString(i);
            
            result.add(res);
        }
        return result;
    }
}
