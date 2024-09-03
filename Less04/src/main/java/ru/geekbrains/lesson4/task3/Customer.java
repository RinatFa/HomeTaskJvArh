package ru.geekbrains.lesson4.task3;

import java.util.Collection;

/**
 * Покупатель
 */
public class Customer implements ICustomer {
    private static int counter = 1000;
    private int id;
    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "\n  Customer " +
                "id= " + id;
    }
}
