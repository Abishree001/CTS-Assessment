import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    // Linear search by title
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    // Binary search by title (requires sorted array)
    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        targetTitle = targetTitle.toLowerCase();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midTitle = books[mid].title.toLowerCase();
            int comparison = targetTitle.compareTo(midTitle);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void displayBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Data Structures", "Mark Allen"),
            new Book(2, "Java Programming", "James Gosling"),
            new Book(3, "Python Basics", "Guido Van Rossum"),
            new Book(4, "Machine Learning", "Andrew Ng"),
            new Book(5, "Artificial Intelligence", "Stuart Russell")
        };

        System.out.println("Available Books:");
        displayBooks(books);

        String searchTitle = "Machine Learning";

        // Linear Search
        System.out.println("\n🔍 Linear Search for: " + searchTitle);
        Book foundLinear = linearSearch(books, searchTitle);
        System.out.println(foundLinear != null ? " Found: " + foundLinear : "❌ Not found");

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        // Binary Search
        System.out.println("\n🔍 Binary Search for: " + searchTitle);
        Book foundBinary = binarySearch(books, searchTitle);
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "❌ Not found");
    }
}
