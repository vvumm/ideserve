public class BuySellStocks {

	public static int maximumProfit(int[] stockPrices)
	{
		int profit = 0;
		int minimumPrice = Integer.MAX_VALUE;
		/* 
		 * for any given day, maximum profit obtainable is - 
		 * maximum of(maximum profit obtained till previous day, stock price on that day - minimum stock price so far)
		 */
		for(int i = 0; i < stockPrices.length; i++)
		{
			profit = Math.max(profit, stockPrices[i] - minimumPrice);
			minimumPrice = Math.min(stockPrices[i], minimumPrice);
		}

		return profit;
	}

	public static void main(String args[])
	{
		int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};

		System.out.println("maximum profit that could be obtained is: " + maximumProfit(stockPrices));
	}
}
