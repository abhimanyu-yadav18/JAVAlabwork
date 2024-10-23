import java.util.Scanner;
public class validation {
    public static void validateCard(String ccNumber) {

        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number");
            return;
        }

        char lastDigitChar = ccNumber.charAt(ccNumber.length() - 1);
        int lastDigit = Character.getNumericValue(lastDigitChar);
        String remainingNumber = ccNumber.substring(0, ccNumber.length() - 1);

        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();

        int[] processedDigits = new int[reversedNumber.length()];
        for (int i = 0; i < reversedNumber.length(); i++) {
            int currentDigit = Character.getNumericValue(reversedNumber.charAt(i));
            if ((i + 1) % 2 != 0) {
                currentDigit *= 2;
                if (currentDigit > 9) {
                    currentDigit = (currentDigit / 10) + (currentDigit % 10);
                }
            }
            processedDigits[i] = currentDigit;
        }

        int totalSum = 0;
        for (int digit : processedDigits) {
            totalSum += digit;
        }

        int calculatedValue = 10 - (totalSum % 10);
        if (calculatedValue == lastDigit) {
            System.out.println("Valid credit card number");
        } else {
            System.out.println("Invalid credit card number");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the credit card number: ");
        String inputNumber = scanner.nextLine();
        validateCard(inputNumber);
    }
}