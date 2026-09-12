public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] firstSample = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(firstSample));

        int[] secondSample = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(secondSample));
    }

    static int maxProfit(int[] prices) {
        int lowestPriceSoFar = prices[0];
        int maxProfitSoFar = 0;

        for (int dayIndex = 1; dayIndex < prices.length; dayIndex++) {
            int potentialProfit = prices[dayIndex] - lowestPriceSoFar;
            maxProfitSoFar = Math.max(maxProfitSoFar, potentialProfit);
            lowestPriceSoFar = Math.min(lowestPriceSoFar, prices[dayIndex]);
        }

        return maxProfitSoFar;
    }
}
