package ru.geekbrains.lesson4.task3;

public class CustomerProvider implements ICustProvider {
    private IDatabase databaseI;

    public CustomerProvider(IDatabase databaseI) {
        this.databaseI = databaseI;
    }

    @Override
    public Customer getCustomer(String login, String password) {
        Customer customer = new Customer();
        databaseI.addCustomer(customer);
        return customer;
    }
}
