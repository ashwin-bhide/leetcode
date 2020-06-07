class Solution {
    //sort in descending order by height
    //if heights are equal, sort in ascending order of k
    public class HeightComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            int h1 = a[0];
            int h2 = b[0];
            int k1 = a[1];
            int k2 = b[1];
            if(h1==h2)
                return k1-k2;
            return h2-h1;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new HeightComparator());
        
        List<int[]> result = new ArrayList();
        
        for(int[] p:people){
            result.add(p[1],p); //List.add(atIndex,element) adds element at given index, shifting elements if place is already occupied
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}
