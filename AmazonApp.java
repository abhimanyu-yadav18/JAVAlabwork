package LAB7;


import java.util.*;

// Customer Class
class Customer {
    private String id;
    private String name;
    private String email;
    private int loyaltyPoints;

    public Customer(String id, String name, String email, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

// Product Class
class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Order Class
class Order {
    private String id;
    private String customerId;
    private String productId;
    private Date deliveryDate;

    public Order(String id, String customerId, String productId, Date deliveryDate) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.deliveryDate = deliveryDate;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productId='" + productId + '\'' +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

// Comparator for sorting Products by price
class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

// Comparator for sorting Customers by loyalty points
class CustomerLoyaltyComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints()); // Descending order
    }
}

public class AmazonApp {
    public static void main(String[] args) {
        // ArrayLists for dynamic storage
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        // HashMap for fast retrieval
        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        // HashSet for unique products per customer
        HashSet<String> uniqueProducts = new HashSet<>();

        // TreeSet for sorted products by price
        TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());

        // TreeSet for sorted customers by loyalty points
        TreeSet<Customer> sortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());

        // Adding sample data
        Customer customer1 = new Customer("C001", "Alice", "alice@example.com", 150);
        Customer customer2 = new Customer("C002", "Bob", "bob@example.com", 200);

        Product product1 = new Product("P001", "Laptop", 999.99);
        Product product2 = new Product("P002", "Smartphone", 699.99);

        Order order1 = new Order("O001", "C001", "P001", new Date());

        // Populating collections
        customers.add(customer1);
        customers.add(customer2);
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);

        products.add(product1);
        products.add(product2);
        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);

        orders.add(order1);

        uniqueProducts.add(product1.getId());
        uniqueProducts.add(product2.getId());

        sortedProducts.add(product1);
        sortedProducts.add(product2);

        sortedCustomers.add(customer1);
        sortedCustomers.add(customer2);

        // Display sorted products
        System.out.println("Products sorted by price:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }

        // Display sorted customers
        System.out.println("\nCustomers sorted by loyalty points:");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }
    }
}

