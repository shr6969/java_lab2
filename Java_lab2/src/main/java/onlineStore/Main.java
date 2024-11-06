package onlineStore;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product.Builder()
                .name("Laptop")
                .description("Gaming Laptop")
                .price(1200.00)
                .stockQuantity(5)
                .build();

        Product smartphone = new Product.Builder()
                .name("Smartphone")
                .description("Latest Model Smartphone")
                .price(800.00)
                .stockQuantity(10)
                .build();

        Product headphones = new Product.Builder()
                .name("Headphones")
                .description("Earbud Headphones")
                .price(150.00)
                .stockQuantity(50)
                .build();

        Product keyboard = new Product.Builder()
                .name("Keyboard")
                .description("Mechanical Keyboard")
                .price(120.00)
                .stockQuantity(30)
                .build();

        List<Product> products = new ArrayList<>(Arrays.asList(laptop, smartphone, headphones, keyboard));

        System.out.println("All Products:");
        products.forEach(System.out::println);

        System.out.println("\nProducts with stock quantity > 20:");
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getStockQuantity() > 20)
                .collect(Collectors.toList());
        filteredProducts.forEach(System.out::println);

        System.out.println("\nProducts sorted by price (ascending):");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println);

        System.out.println("\nMost expensive product:");
        Product mostExpensiveProduct = products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);  // In case there are no products
        System.out.println(mostExpensiveProduct);

        System.out.println("\nProducts with price less than $200:");
        List<Product> cheapProducts = products.stream()
                .filter(p -> p.getPrice() < 200)
                .collect(Collectors.toList());
        cheapProducts.forEach(System.out::println);
    }
}
