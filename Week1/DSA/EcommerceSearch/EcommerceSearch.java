import java.util.Arrays;

class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Product{ID=" + productId + ", Name='" + name + "', Price=" + price + "}";
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", 999.99),
                new Product(102, "Phone", 499.99),
                new Product(103, "Tablet", 299.99),
                new Product(104, "Headphones", 79.99),
                new Product(105, "Smartwatch", 199.99)
        };

        System.out.println("=== Linear Search ===");
        Product result1 = linearSearch(products, 103);
        System.out.println(result1 != null ? "Found: " + result1 : "Not found");

        Arrays.sort(products, (a, b) -> a.productId - b.productId);

        System.out.println("\n=== Binary Search ===");
        Product result2 = binarySearch(products, 104);
        System.out.println(result2 != null ? "Found: " + result2 : "Not found");

        System.out.println("\n=== Search for non-existent product ===");
        Product result3 = linearSearch(products, 999);
        System.out.println(result3 != null ? "Found: " + result3 : "Product not found");
    }
}