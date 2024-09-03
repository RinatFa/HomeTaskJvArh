package ru.geekbrains.lesson4.task3;

import java.time.LocalDate;
import java.util.Collection;

public interface IDatabase {
    Collection<Ticket> getTickets();

    double getTicketAmount();

    int createTicketOrder(int clientId);

    void addTicket(int clientId, LocalDate date, String qrcode)
            throws RuntimeException;

    void addCustomer(Customer customer);

}
