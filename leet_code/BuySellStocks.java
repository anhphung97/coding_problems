//Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
// design an algorithm to find the maximum profit.

public class BuySellStocks 
{
    public int maxProfit(int[] prices) 
    {
        // max profit so far
        int maxProfit = Integer.MIN_VALUE;
        
        // two pointers
        int left = 0;
        int right = 0;
        
        // move the pointers
        while (left < prices.length)
        {
            // find the decreasing sequence
            while (left < prices.length - 1 && prices[left] >= prices[left+1])
                left ++;
            
            right = left + 1;
            
            // end of sequence already
            if (right == prices.length)
                return maxProfit == Integer.MIN_VALUE? 0 : maxProfit;
            
            // find the maximum to the right of "left"
            for (int i = left + 1; i < prices.length; i++)
                if (prices[i] > prices[right])
                    right = i;
            
            if (right < prices.length && prices[left] <= prices[right])
            {
                // find the minimum between "left" and "right"
                for (int i = left + 1; i < right; i++)
                    if (prices[i] < prices[left])
                        left = i;
                
                // update max profit
                if (prices[right] - prices[left] > maxProfit)
                    maxProfit = prices[right] - prices[left];
                
                // move left pointer past right pointer
                left = right + 1;
            }
            else
                left ++;
        }
        
        // return max profit
        return maxProfit == Integer.MIN_VALUE? 0 : maxProfit;
    }
}
