class Solution {
    List<List<String>> result = new ArrayList<>();
    //sort products array lexicographically
    public class LexCompare implements Comparator<String>{
        public int compare(String s1, String s2){
            return s1.compareTo(s2);
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products,new LexCompare());
        for(int i=0;i<searchWord.length();i++)
            addSuggestion(searchWord,products,i);
        
        return result;
    }
    //below function gets called searchWord.length times
    public void addSuggestion(String searchWord,String[] products,int index){
        List<String> suggest = new ArrayList<String>();
        
        //for word at each call; eg. m, mo, mou, mous, mouse
        String temp = searchWord.substring(0,index+1);
        //iterate through given products array and find products that start with temp, limit result to 3
        for(int i=0,k=0;i<products.length && k<3;i++){
            if(products[i].startsWith(temp)){
                suggest.add(products[i]);
                k++; //only increment k if product has been added to suggest
            }
        }
        
        result.add(suggest);
    }
}
