package LAB6;

import java.util.LinkedList;
import java.util.Random;

class CounterEmptyException extends Exception {
    public CounterEmptyException(String message) {
        super(message);
    }
}

class CoffeeCounter {
    private final int capacity = 3; // Maximum number of coffee cups on the counter
    private final LinkedList<String> counter = new LinkedList<>();

    // Add coffee to the counter
    public synchronized void addCoffee(String coffee) throws InterruptedException {
        while (counter.size() == capacity) {
            System.out.println("Barista is waiting. Counter is full.");
            wait();
        }
        counter.add(coffee);
        System.out.println(coffee + " added. Counter: " + counter.size());
        notifyAll(); // Notify waiting threads
    }

    // Remove coffee from the counter (for customers or reviewers)
    public synchronized String takeCoffee(String consumerName) throws InterruptedException, CounterEmptyException {
        while (counter.isEmpty()) {
            System.out.println(consumerName + ": Counter is empty. Waiting...");
            wait();
        }
        String coffee = counter.poll();
        if (coffee == null) {
            throw new CounterEmptyException("No coffee available!");
        }
        System.out.println(consumerName + " took " + coffee + ". Counter: " + counter.size());
        notifyAll(); // Notify waiting threads
        return coffee;
    }
}

class Barista implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;
    private final String name;

    public Barista(String name, CoffeeCounter counter, int coffeeCount) {
        this.name = name;
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= coffeeCount; i++) {
                counter.addCoffee(name + " prepared coffee " + i);
                Thread.sleep(500); // Simulate time to prepare coffee
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Customer implements Runnable {
    private final CoffeeCounter counter;
    private final int coffeeCount;
    private final String name;

    public Customer(String name, CoffeeCounter counter, int coffeeCount) {
        this.name = name;
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.takeCoffee(name);
                Thread.sleep(500); // Simulate time between picking up coffees
            }
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println(name + " encountered an issue: " + e.getMessage());
        }
    }
}

class CoffeeReviewer implements Runnable {
    private final CoffeeCounter counter;

    public CoffeeReviewer(CoffeeCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // lets delay reviewer to let customers pick coffee first
            counter.takeCoffee("reviewer");
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println("reviewer encountered an issue-" + e.getMessage());
        }
    }
}

public class CoffeeShopSimulation {
    public static void main(String[] args) {
        CoffeeCounter counter = new CoffeeCounter();

        Thread barista1 = new Thread(new Barista("barista1", counter, 3));
        Thread barista2 = new Thread(new Barista("barista2", counter, 4));

        Thread customer1 = new Thread(new Customer("lisa_customer1", counter, 2));
        Thread customer2 = new Thread(new Customer("lilly_customer2", counter, 1));
        Thread customer3 = new Thread(new Customer("lucas_customer3", counter, 2));

        Thread reviewer = new Thread(new CoffeeReviewer(counter));

        // Start all threads
        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();

        // Join all threads to ensure complete execution
        try {
            barista1.join();
            barista2.join();
            customer1.join();
            customer2.join();
            customer3.join();
            reviewer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Simulation finished.");
    }
}
