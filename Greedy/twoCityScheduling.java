class Solution {
    public class DifferenceComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            int diff1 = a[0] - a[1]; //At index i, city A cost - city B cost
            int diff2 = b[0] - b[1];
            return diff1-diff2; //sort in ascending order
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        //greedy approach
        //minimize the cost
        Arrays.sort(costs,new DifferenceComparator());
        
        int total = 0;
        int n = costs.length;
        for(int i=0;i<n/2;i++){
            total += costs[i][0] + costs[i+n/2][1]; //first half of costs, select city A, 2nd half select city B
        }
        
        return total;
    }
}
