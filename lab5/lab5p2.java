package LAB5;

interface WaterConservation {
    int calculateTrappedWater(int[] blockHeights);
}

// Abstract class implementing the interface
abstract class RainySConservation implements WaterConservation {}

// Concrete class extending the abstract class
class CityConservation extends RainySConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;
        if (n == 0) return 0;

        // Step 1: Create leftMax and rightMax arrays
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        // Step 2: Calculate trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return totalWater;
    }
}

// Main class to test the implementation
public class lab5p2o {
    public static void main(String[] args) {
        // Create an instance of CityBlockConservation
        CityConservation conservation = new CityConservation();

        // Test Case 1
        int[] blockHeights1 = {3, 0, 0, 2, 0, 4};
        System.out.println("Trapped Water (Test Case 1): " + conservation.calculateTrappedWater(blockHeights1));
        // Expected Output: 10

        // Test Case 2
        int[] blockHeights2 = {3, 0, 2, 0, 4};
        System.out.println("Trapped Water (Test Case 2): " + conservation.calculateTrappedWater(blockHeights2));
        // Expected Output: 7

        // Test Case 3
        int[] blockHeights3 = {1, 2, 3, 4, 5};
        System.out.println("Trapped Water (Test Case 3): " + conservation.calculateTrappedWater(blockHeights3));
        // Expected Output: 0

        // Test Case 4
        int[] blockHeights4 = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped Water (Test Case 4): " + conservation.calculateTrappedWater(blockHeights4));
        // Expected Output: 9
    }
}

