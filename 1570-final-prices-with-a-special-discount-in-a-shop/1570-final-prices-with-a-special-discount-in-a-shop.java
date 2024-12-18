class Solution {
    public int[] finalPrices(int[] prices) {
        int discount = 0;

        for(int i=0; i< prices.length ; i++) {
            for(int j = i+1;  j< prices.length ; j++) {
                if(prices[i] >= prices[j] && i < j) {
                    discount = prices[i] - prices[j];
                    prices[i] = discount;
                    discount = 0;
                    break;
                }
            }
        }
        return prices;
    }
}