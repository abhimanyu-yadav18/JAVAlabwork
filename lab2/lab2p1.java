package Lab2;
import java.util.*;

/**
 * Step 1:sort the give array in ascending order
 * step 2:take 2 array with have uniquenumber,frequcies of those uniqueNumber by loop the step1(Sorted array)
 * step3:as we get 2 arrays since frequencies are contain repeated values we need to selected the unique of maximun
 * so sort the frequents number in Descending associated with unique number
 * as per k choice we will loop frequencies the print the associated unique numbers
 */
public class lab2p1 {

    // static variable to store the input array
    static int[] arr ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
       // Initialize the array with user-defined size
                arr = new int[n];

        //  user to enter the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        //  user for the number of top frequent elements to find
        System.out.print("Enter the value of K (number of top frequent elements to find): ");
        int K = scanner.nextInt();// number of top frequent elements to find
        findTopKFrequent(K);
    }

    // Static method to find the top K frequent numbers
    public static void findTopKFrequent(int K) {
        // Step 1: Sort the array using bubble sort
        bubbleSort(arr);

        // Step 2: Identify unique numbers and their frequencies
        int n = arr.length;
        int[] numbers = new int[n];  // To store unique numbers
        int[] frequencies = new int[n];  // To store corresponding frequencies

        int index = 0;  // Pointer for unique numbers and their frequencies

        for (int i = 0; i < n; ) {
            int num = arr[i];
            int freq = 0;

            // count the frequency of the current number
            while (i < n && arr[i] == num) {
                freq++;
                i++;
            }

            // Store the unique number and its frequency
            numbers[index] = num;
            frequencies[index] = freq;
            index++;
        }

        // Step 3: Sort the numbers and frequencies in descending order
        bubbleSortFrequencies(numbers, frequencies, index);

        // Step 4: Print the top K numbers
        System.out.println("Top " + K + " frequent numbers:");
        for (int i = 0; i < K; i++) {
            System.out.println(numbers[i] + " (frequency: " + frequencies[i] + ")");
        }
    }

    // Method to sort the array using bubble sort in ascending order
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Method to sort the numbers and frequencies in descending order
    public static void bubbleSortFrequencies(int[] numbers, int[] frequencies, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                // Check if the frequency should be swapped or if the same frequency but larger number
                if (frequencies[j] < frequencies[j + 1] ||
                        (frequencies[j] == frequencies[j + 1] && numbers[j] < numbers[j + 1])) {

                    // Swap frequencies
                    int tempFreq = frequencies[j];
                    frequencies[j] = frequencies[j + 1];
                    frequencies[j + 1] = tempFreq;

                    // Swap corresponding numbers of unique Number
                    int tempNum = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tempNum;
                }
            }
        }
    }


}


