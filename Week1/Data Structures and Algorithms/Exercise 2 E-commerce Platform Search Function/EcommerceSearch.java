import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    // Linear Search: O(n)
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search: O(log n) — requires sorted array by productName
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        targetName = targetName.toLowerCase();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midName = products[mid].productName.toLowerCase();
            int cmp = targetName.compareTo(midName);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Chair", "Furniture"),
            new Product(103, "Headphones", "Electronics"),
            new Product(104, "Shoes", "Fashion"),
            new Product(105, "Book", "Education")
        };

        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p);
        }

        String target = "Shoes";

        // Linear Search Test
        System.out.println("\n--- Linear Search ---");
        Product foundLinear = linearSearch(products, target);
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found");

        // Sort products for binary search by productName
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search Test
        System.out.println("\n--- Binary Search ---");
        Product foundBinary = binarySearch(products, target);
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found");
    }
}
