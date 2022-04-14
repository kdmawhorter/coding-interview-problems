package interviewbit;

public class BuyingStocks {

    /**
     * Given an input stock price array, return the maximum profit that could be made if you optimally purchased and
     * sold stocks given those prices, given that you can only choose to buy, sell, or do nothing each day and
     * you may only one share at a time.
     *
     * @param stockPrices - an int array representing stock prices
     * @return The maximum profit that could be made with the constraints above
     */
    public int bestTimeToBuy_2(int[] stockPrices) {
        if (stockPrices!=null && stockPrices.length>1) {
            int[] maxProfit = new int[stockPrices.length];
            maxProfit[maxProfit.length-1] = 0;
            for (int i = stockPrices.length - 2; i >= 0; i--) {
                maxProfit[i] = maxProfit[i+1] + Math.max(stockPrices[i+1]-stockPrices[i], 0);
            }
            return maxProfit[0];
        }
        return 0;
    }
}
