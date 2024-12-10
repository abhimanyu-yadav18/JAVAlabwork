package LAB6;

import java.util.concurrent.atomic.AtomicInteger;

public class CoinCombination {

    // Atomic variable to store the result
    private static AtomicInteger result = new AtomicInteger(0);

    // Method to count the ways to make the sum using dynamic programming
    public static void countWays(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case: One way to make sum 0

        // Fill the dp array using all coins
        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        // Update the shared result atomically
        result.addAndGet(dp[sum]);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] coins1 = {1, 2, 3};
        int sum1 = 4;

        // Create and start a thread for the first test case
        Thread thread1 = new Thread(() -> countWays(coins1, sum1));
        thread1.start();

        try {
            thread1.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Output the result for the first test case
        System.out.println("Number of ways to make sum " + sum1 + " with coins " + java.util.Arrays.toString(coins1) + ": " + result.get());

        // Reset result for the next test case
        result.set(0);

        // Test Case 2
        int[] coins2 = {2, 5, 3, 6};
        int sum2 = 10;

        // Create and start a thread for the second test case
        Thread thread2 = new Thread(() -> countWays(coins2, sum2));
        thread2.start();

        try {
            thread2.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Output the result for the second test case
        System.out.println("Number of ways to make sum " + sum2 + " with coins " + java.util.Arrays.toString(coins2) + ": " + result.get());
    }
}