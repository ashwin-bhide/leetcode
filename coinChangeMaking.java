class Solution {
    public int coinChange(int[] coins, int amount) {
        //make sure that coin denominations are in sorted order
        Arrays.sort(coins);
        int[] matrix = new int[amount+1];
        matrix[0] = 0;
        for(int i=1;i<=amount;i++)
            matrix[i] = Integer.MAX_VALUE-1;
        
        for(int coinIndex=0;coinIndex<coins.length;coinIndex++){
            for(int amtSubValue=1;amtSubValue<=amount;amtSubValue++){
                if(amtSubValue>=coins[coinIndex]){
                    if(matrix[amtSubValue-coins[coinIndex]]+1 < matrix[amtSubValue])
                        matrix[amtSubValue] = 1 + matrix[amtSubValue-coins[coinIndex]];
                }
            }
        }
        
        return (matrix[amount]==Integer.MAX_VALUE-1)?-1:matrix[amount];
    }
}
