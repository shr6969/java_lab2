package onlineStore;

import java.util.Objects;

/**
 * Клас, який представляє товар в інтернет-магазині.
 * Містить інформацію про назву, опис, ціну та кількість на складі товару.
 * Об'єкти цього класу створюються за допомогою шаблону Builder.
 */
public class Product implements Comparable<Product> {
    private String name; // Назва товару
    private String description; // Опис товару
    private double price; // Ціна товару
    private int stockQuantity; // Кількість на складі

    /**
     * Конструктор класу Product
     * використовується для створення об‘єкта за допомогою Builder
     *
     * @param builder Об'єкт Builder для встановлення полів Product.
     */
    public Product(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
    }


    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    /**
     * Повертає текстове представлення об'єкта Product.
     * Включає всі поля: назву, опис, ціну та кількість на складі товару.
     *
     * @return Рядок, що містить усю інформацію про товар
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    /**
     * Порівнює об‘єкти Product.
     * Два об'єкти вважаються рівними, якщо всі їхні поля співпадають.
     *
     * @param o Об'єкт для порівняння з поточним об'єктом.
     * @return true якщо об'єкти однакові, інакше {@code false}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                stockQuantity == product.stockQuantity &&
                name.equals(product.name) &&
                description.equals(product.description);
    }

    /**
     * Генерує хеш-код для об‘єкту класу Animal. Хеш-код створюється на основі усіх полів
     *
     * @return хеш-код об‘єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, stockQuantity);
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }

    /**
     * Внутрішній клас Builder для створення об'єктів Product.
     * Дозволяє налаштовувати параметри товару перед його створенням.
     */
    public static class Builder {
        private String name;
        private String description;
        private double price;
        private int stockQuantity;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder stockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
