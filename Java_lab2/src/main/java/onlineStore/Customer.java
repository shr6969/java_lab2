package onlineStore;

import java.util.Objects;

/**
 * Клас, який представляє замовника
 * Містить інформацію про ім‘я замовника, прізвище, адресу електронної пошти,
 * та номер телефону
 */
public class Customer implements Comparable<Customer> {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

    /**
     * Конструктор для ініціалізації замовника
     *
     * @param firstName   ім‘я замовника
     * @param lastName    прізвище замовника
     * @param email       адреса ел. пошти
     * @param phoneNumber номер телефону
     */
    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    /**
     * Повертає рядкове представлення об‘єкту Customer
     *
     * @return рядок, що містить усю інформацію про замовника
     */
    @Override
    public String toString() {
        return "Customer:\n" +
                "  First Name: '" + firstName + "'\n" +
                "  Last Name: '" + lastName + "'\n" +
                "  Email: '" + email + "'\n" +
                "  Phone Number: '" + phoneNumber + "'";
    }

    /**
     * Порівнює об‘єкти Customer.
     * Два об'єкти вважаються рівними, якщо всі їхні поля співпадають.
     *
     * @param obj об‘єкт для порівняння
     * @return true якщо об‘єкти рівні, false в іншому випадку
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                email.equals(customer.email) &&
                phoneNumber.equals(customer.phoneNumber);
    }

    /**
     * Генерує хеш-код для об‘єкту класу Animal. Хеш-код створюється на основі усіх полів
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }

    @Override
    public int compareTo(Customer other) {
        return this.lastName.compareTo(other.lastName);
    }
}
