package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных
 */
public class Database implements IDatabase {
    private static int counter = 7000010;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Database() {
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     */
    public double getTicketAmount() {
        return 45.0;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

    public void addTicket(int clientId, LocalDate date, String qrcode)
            throws RuntimeException {
        // ПРЕДУСЛОВИЕ
        if (clientId <= 0) {
            throw new RuntimeException("Пользователь не найден.");
        }

        // РАБОТА С ДАННЫМИ
        tickets.add(new Ticket(clientId, date, qrcode));

        // ПОСТУСЛОВИЕ
        if (tickets == null) {
            throw new RuntimeException("Ошибка обработки данных.");
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public String toString() {
        return "\n      билеты= " + tickets +
                ",\n      покупатели= " + customers;
    }
}
