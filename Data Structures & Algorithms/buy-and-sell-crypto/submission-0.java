class Solution {
    public int maxProfit(int[] prices) {
        
    int  buy_price= Integer.MAX_VALUE;
    int result=0;
    
    
        for(int  i=0;i<prices.length;i++){
            if(prices[i]<buy_price){
                buy_price=prices[i];

            }
            else{
                int profit=prices[i]-buy_price;
                result=Math.max(result, profit);


            }
        }

        return result;
    }
}
