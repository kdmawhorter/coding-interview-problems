package interviewbit;

/**
 * A class designed to answer problems related to InterviewBit Amazon Problems on the Best Time to Buy and Sell Stocks.
 */
public class BuyingStocks {

    /**
     * Given an input stock price array, return the maximum profit that could be made if you optimally purchased and
     * sold stocks given those prices, given that you can only choose to buy, sell, or do nothing each day, you may only
     * own one share at a time, and you may only make one transaction total.<br>
     * <br>
     * Solves the problem posed
     * <a href="https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/">here</a>
     *
     * @param stockPrices an int array representing stock prices
     * @return The maximum profit that could be made with the constraints above
     */
    public int bestTimeToBuy_1(int[] stockPrices) {
        if (stockPrices!=null && stockPrices.length>1) {
            return 0;
        }
        return 0;
    }

    /**
     * Given an input stock price array, return the maximum profit that could be made if you optimally purchased and
     * sold stocks given those prices, given that you can only choose to buy, sell, or do nothing each day and
     * you may only own one share at a time.<br>
     * <br>
     * Solves the problem posed
     * <a href="https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/">here</a>
     *
     * @param stockPrices an int array representing stock prices
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

    /**
     * Given an input stock price array, return the maximum profit that could be made if you optimally purchased and
     * sold stocks given those prices, given that you can only choose to buy, sell, or do nothing each day, you may only
     * own one share at a time, and you are limited to only making two transactions.<br>
     * <br>
     * Solves the problem posed
     * <a href="https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/">here</a>
     *
     * @param stockPrices an int array representing stock prices
     * @return The maximum profit that could be made with the constraints above
     */
    public int bestTimeToBuy_3(int[] stockPrices) {
        if (stockPrices!=null && stockPrices.length>1) {
            int[] currentOpenTransaction = new int[stockPrices.length];
            int[] largestSingleTransaction = new int[stockPrices.length];
            int[] largestDoubleTransactions = new int[stockPrices.length];

            for (int i = stockPrices.length - 2; i >= 0; i--) {
                if (stockPrices[i] <= stockPrices[i + 1]) {
                    currentOpenTransaction[i] = currentOpenTransaction[i + 1] + (stockPrices[i + 1] - stockPrices[i]);
                    largestSingleTransaction[i] = largestSingleTransaction[i + 1];
                    largestDoubleTransactions[i] = largestDoubleTransactions[i + 1];
                } else {
                    currentOpenTransaction[i] = 0;
                    largestDoubleTransactions[i] = Math.max(
                            currentOpenTransaction[i + 1] + largestSingleTransaction[i + 1],
                            largestDoubleTransactions[i + 1]);
                    largestSingleTransaction[i] = Math.max(currentOpenTransaction[i + 1],
                            largestSingleTransaction[i +1]);
                }
            }

            return Math.max(currentOpenTransaction[0] + largestSingleTransaction[0], largestDoubleTransactions[0]);
        }
        return 0;
    }
}
