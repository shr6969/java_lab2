package onlineStore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Клас, який представляє замовлення клієнта в інтернет-магазині.
 */
public class Order {
    private String orderNumber;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private LocalDate orderDate;


    public Order(String orderNumber, Customer customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
        this.orderDate = LocalDate.now();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public double getTotalAmount() { return totalAmount; }

    /**
     * Повертає текстове представлення об'єкта Order.
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                '}';
    }

    /**
     * Порівнює об‘єкти Order.
     * Два об'єкти вважаються рівними, якщо всі їхні поля співпадають.
     *
     * @param o об‘єкт для порівняння
     * @return true якщо об‘єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalAmount, totalAmount) == 0 &&
                orderNumber.equals(order.orderNumber) &&
                customer.equals(order.customer) &&
                products.equals(order.products);
    }

    /**
     * Генерує хеш-код для об‘єкту класу Animal. Хеш-код створюється на основі усіх полів
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, customer, products, totalAmount);
    }

    // Внутрішній клас Builder для побудови об'єкта Order
    public static class Builder {
        private String orderNumber;
        private Customer customer;
        private List<Product> products = new ArrayList<>();

        public Builder orderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder addProduct(Product product) {
            this.products.add(product);
            return this;
        }

        public Order build() {
            Order order = new Order(orderNumber, customer);
            for (Product product : products) {
                order.addProduct(product);
            }
            return order;
        }
    }
}
