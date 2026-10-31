import java.util.Scanner;

public class BestSingleTradeProfit {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] prices = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            prices[index] = Integer.parseInt(tokens[index]);
        }

        System.out.println(maxProfit(prices));

        userInputScanner.close();
    }

    // Single pass: track the lowest price so far and the best profit selling today.
    // Time complexity: O(n). Space complexity: O(1).
    static int maxProfit(int[] prices) {
        int lowestPriceSoFar = Integer.MAX_VALUE;
        int bestProfit = 0;

        for (int price : prices) {
            if (price < lowestPriceSoFar) {
                lowestPriceSoFar = price;
            } else if (price - lowestPriceSoFar > bestProfit) {
                bestProfit = price - lowestPriceSoFar;
            }
        }

        return bestProfit;
    }

    // Checking every (buy day, sell day) pair: O(n^2) time, O(1) space.
    // At scale the single pass is preferable: for a million daily prices it does about a
    // million steps, while the pair check does roughly five hundred billion.
    static int maxProfitBruteForce(int[] prices) {
        int bestProfit = 0;

        for (int buyDay = 0; buyDay < prices.length; buyDay++) {
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                bestProfit = Math.max(bestProfit, prices[sellDay] - prices[buyDay]);
            }
        }

        return bestProfit;
    }
}
