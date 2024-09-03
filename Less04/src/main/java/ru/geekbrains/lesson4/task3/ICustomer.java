package ru.geekbrains.lesson4.task3;

import java.util.Collection;

public interface ICustomer {
    int getId();
    Collection<Ticket> getTickets();
    void setTickets(Collection<Ticket> tickets);
}
