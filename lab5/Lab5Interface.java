package LAB5;
import java.util.*;
//Concept is Interface
//Program:1

/**
 * An interface in Java is an abstract type
 * that defines a  blueprint for a class to follow.
 * It specifies a set of methods that must be implemented by any class
 * that implements the interface.
 * Interfaces are abstract, meaning they cannot be instantiated directly,
 * and they provide a way to achieve multiple inheritance in Java.
 */

/**
 * Interfaces--full-->Abstraction-->objects can't be created
 * Interfaces method ---> by default are abstract method without any body
 * Constants:Interfaces can declare constants, which are public, static, and final.
 * The point meaning is the variable which are declare under the interface are should be public static final which used for implementation not for modification
 * Multiple Inheritance: A class can implement multiple interfaces, but it can only extend one class (single inheritance).
 * Implementation: Classes that implement an interface must provide an implementation for all methods declared in the interface.
 */
//s1:define the Interface
interface BankInterface {
    //any variable are public static final
    double getBalance();      // Abstract method to get balance
    double getInterestRate(); // Abstract method to get interest rate
}

//s2: Implement the Interface in BankA
class BankA implements BankInterface {
    private double balance;

    public BankA(double balance) {
        this.balance = balance;
    }

    //overriding here which defination the abstract method with body implementatio
    public double getBalance() {
        return balance;
    }


    public double getInterestRate() {
        return 7.0;
    }
}

// Step 2: Implement the Interface in BankB
class BankB implements BankInterface {
    private double balance;

     BankB(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4; // 7.4% interest rate
    }
}

//same s2:implement the interface in BankC
class BankC implements BankInterface {
    private double balance;

     BankC(double balance) {
        this.balance = balance;
    }

    //abstract methods
    public double getBalance() {
        return balance;
    }

    //abstract methods
    public double getInterestRate() {
        return 7.9; // 7.9% interest rate
    }
}

// Step 3: Main Class to Invoke Methods
public class Lab5Interface {
    public static void main(String[] args) {
        // Step 4: Create objects of each bank
        BankA bankA = new BankA(10000); //reference variables
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        // Display details for BankA
        System.out.println("Bank A:");
        System.out.println("Balance: " + bankA.getBalance());
        System.out.println("Interest Rate: " + bankA.getInterestRate() + "%");

        // Display details for BankB
        System.out.println("\nBank B:");
        System.out.println("Balance: " + bankB.getBalance());
        System.out.println("Interest Rate: " + bankB.getInterestRate() + "%");

        // Display details for BankC
        System.out.println("\nBank C:");
        System.out.println("Balance: " + bankC.getBalance());
        System.out.println("Interest Rate: " + bankC.getInterestRate() + "%");
    }
}


