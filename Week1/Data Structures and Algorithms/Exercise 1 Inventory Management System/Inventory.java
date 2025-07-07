import java.util.*;

public class Inventory {
    private static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Search by Product ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> updateProduct(sc);
                case 3 -> deleteProduct(sc);
                case 4 -> displayAll();
                case 5 -> searchProduct(sc);
                case 0 -> System.out.println("Exiting system.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void addProduct(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        if (inventory.containsKey(id)) {
            System.out.println("Product ID already exists.");
        } else {
            inventory.put(id, new Product(id, name, qty, price));
            System.out.println("Product added.");
        }
    }

    public static void updateProduct(Scanner sc) {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        Product p = inventory.get(id);

        if (p != null) {
            sc.nextLine();
            System.out.print("New Name: ");
            String name = sc.nextLine();
            System.out.print("New Quantity: ");
            int qty = sc.nextInt();
            System.out.print("New Price: ");
            double price = sc.nextDouble();

            p.setProductName(name);
            p.setQuantity(qty);
            p.setPrice(price);

            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(Scanner sc) {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void displayAll() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void searchProduct(Scanner sc) {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();
        Product p = inventory.get(id);
        if (p != null) {
            System.out.println("Found: " + p);
        } else {
            System.out.println("Product not found.");
        }
    }
}
