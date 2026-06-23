class Solution {
    public int maxProfit(int[] prices) {
        int [][] dp=new int[prices.length][2];
        for(int [] row:dp){
            Arrays.fill(row,-1);
        }


        return helper(0, 1, prices, dp);

        

    }

    private int helper(int index, int canBuy, int [] prices, int [][] dp){
        if(index>=prices.length) return 0;

        if(dp[index][canBuy] !=-1) return dp[index][canBuy];


         if(canBuy==1){
            int buy=-prices[index] +helper(index+1, 0, prices, dp);

            int skip=helper(index+1, 1, prices, dp);
            dp[index][canBuy]=Math.max(buy, skip);
         }
         else{
               
               int sell=prices[index]+helper(index+2, 1, prices, dp);
               int skip =helper(index+1,0,prices, dp);
               dp[index][canBuy]=Math.max(sell, skip);
         }


         return dp[index][canBuy];

    }
}